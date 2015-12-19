package com.lt.app.common.view.textview;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Html;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import com.lt.app.R;
import com.lt.app.common.util.StringUtils;

import org.jetbrains.annotations.NotNull;
import org.xml.sax.XMLReader;

import java.util.HashMap;

/**
 * Created by khacpham on 12/17/15.
 */
public class RichTextView extends TextView {

    ResourceTagHandler tagHandler;
    ResourceImageGetter resourceGetter;

    Spanned sa;

    public RichTextView(Context context) {
        super(context);
        init(null);
    }

    public RichTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RichTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        setMovementMethod(LinkMovementMethod.getInstance());
        tagHandler = new ResourceTagHandler(this.getContext());
        resourceGetter = new ResourceImageGetter(this.getContext());

        if(attrs != null){
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RichTextView, 0, 0);
            // TODO get attribute here
            a.recycle();
        }
    }

    public void setRichText(String text){
        sa = Html.fromHtml(text, resourceGetter, tagHandler);

        super.setText(sa);
    }

    public Spanned span(){
        return sa;
    }

    public void setOnClickableListener(ResourceTagHandler.OnClickableListener listener){
        tagHandler.setOnClickableListener(listener);
    }

    public Point getFirstPosThreeDot(){
        TextView parentTextView = this;

        Rect parentTextViewRect = new Rect();

        // Initialize values for the computing of clickedText position
        SpannableString completeText = (SpannableString)(parentTextView).getText();
        Layout textViewLayout = parentTextView.getLayout();

        ClickableSpan[] clickableSpans = completeText.getSpans(0, completeText.length(), ClickableSpan.class);

        ClickableSpan threeDotSpan = clickableSpans[0];
        for(ClickableSpan span: clickableSpans){
            int start = completeText.getSpanStart(span);
            int end = completeText.getSpanEnd(span);
            String subText = completeText.subSequence(start,end).toString();
            if(".....".equalsIgnoreCase(subText)){
                threeDotSpan = span;
                break;
            }
        }

        double startOffsetOfClickedText = completeText.getSpanStart(threeDotSpan);
        double endOffsetOfClickedText = completeText.getSpanEnd(threeDotSpan);

        double startXCoordinatesOfClickedText = textViewLayout.getPrimaryHorizontal((int)startOffsetOfClickedText);
        double endXCoordinatesOfClickedText = textViewLayout.getPrimaryHorizontal((int)endOffsetOfClickedText);

        // Get the rectangle of the clicked text
        int currentLineStartOffset = textViewLayout.getLineForOffset((int)startOffsetOfClickedText);
        int currentLineEndOffset = textViewLayout.getLineForOffset((int)endOffsetOfClickedText);
        boolean keywordIsInMultiLine = currentLineStartOffset != currentLineEndOffset;
        textViewLayout.getLineBounds(currentLineStartOffset, parentTextViewRect);


        // Update the rectangle position to his real position on screen
        int[] parentTextViewLocation = {0,0};
        parentTextView.getLocationOnScreen(parentTextViewLocation);

        double parentTextViewTopAndBottomOffset = (
                parentTextViewLocation[1] -
                        parentTextView.getScrollY() +
                        parentTextView.getCompoundPaddingTop()
        );
        parentTextViewRect.top += parentTextViewTopAndBottomOffset;
        parentTextViewRect.bottom += parentTextViewTopAndBottomOffset;

        parentTextViewRect.left += (
                parentTextViewLocation[0] +
                        startXCoordinatesOfClickedText +
                        parentTextView.getCompoundPaddingLeft() -
                        parentTextView.getScrollX()
        );
        parentTextViewRect.right = (int) (
                parentTextViewRect.left +
                        endXCoordinatesOfClickedText -
                        startXCoordinatesOfClickedText
        );

        int x = (parentTextViewRect.left + parentTextViewRect.right) / 2;
        int y = parentTextViewRect.bottom;
        if (keywordIsInMultiLine) {
            x = parentTextViewRect.left;
        }

        Log.d("TAG","location2:" + x + "," + y);
        return new Point(x,y);
    }
}
