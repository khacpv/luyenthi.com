package com.lt.app.common.view.textview;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.lt.app.R;
import com.lt.app.common.util.StringUtils;

/**
 * Created by khacpham on 12/17/15.
 */
public class RichTextView extends TextView {

    ResourceTagHandler tagHandler;

    Spanned sa;

    private ClipboardManager myClipboard;
    private ClipData myClip;

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

        if(attrs != null){
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RichTextView, 0, 0);
            // TODO get attribute here
            a.recycle();
        }
        initContextMenu();
    }
    final int DEFINITION = 0;
    private void initContextMenu(){
        setTextIsSelectable(true);
        myClipboard = (ClipboardManager) getContext().getSystemService(Activity.CLIPBOARD_SERVICE);
        setCustomSelectionActionModeCallback(new ActionMode.Callback() {

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Remove the "select all" option
                menu.removeItem(android.R.id.selectAll);
                // Remove the "cut" option
                menu.removeItem(android.R.id.cut);
                // Remove the "copy all" option
                menu.removeItem(android.R.id.copy);
                return true;
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Called when action mode is first created. The menu supplied
                // will be used to generate action buttons for the action mode

                // Here is an example MenuItem
                menu.clear();
                menu.add(0, DEFINITION, 0, "Definition").setIcon(R.drawable.icon_info);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Called when an action mode is about to be exited and
                // destroyed
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case DEFINITION:
                        int min = 0;
                        int max = getText().length();
                        if (isFocused()) {
                            final int selStart = getSelectionStart();
                            final int selEnd = getSelectionEnd();

                            min = Math.max(0, Math.min(selStart, selEnd));
                            max = Math.max(0, Math.max(selStart, selEnd));
                        }
                        // Perform your definition lookup with the selected text
                        final CharSequence selectedText = getText().subSequence(min, max);
                        // Finish and close the ActionMode
                        mode.finish();
                        return true;
                    default:
                        break;
                }
                return false;
            }

        });
    }

    public void setRichText(String text){
        sa = Html.fromHtml(text, new ResourceImageGetter(getContext()), tagHandler);
        super.setText(sa);
    }

    public Spanned span(){
        return sa;
    }

    public void setOnAnswerClickListener(ResourceTagHandler.OnAnswerClickListener listener){
        tagHandler.setOnAnswerClickListener(listener);
    }
}
