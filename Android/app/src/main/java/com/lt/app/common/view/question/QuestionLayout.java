package com.lt.app.common.view.question;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by khacpham on 12/16/15.
 */
public abstract class QuestionLayout extends FrameLayout {
    public QuestionLayout(Context context) {
        super(context);
    }

    public QuestionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuestionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected abstract void init();
}
