package com.lt.app.common.view.textview;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import com.lt.app.R;

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
}
