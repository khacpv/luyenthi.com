package com.lt.app.screens.question.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.lt.app.common.view.question.QuestionLayout;

/**
 * Created by khacpham on 12/16/15.
 * Display question with single choice. With image or not
 */
public class Question01SingleChoice extends QuestionLayout {
    public static final String TAG = Question01SingleChoice.class.getSimpleName();

    public Question01SingleChoice(Context context) {
        super(context);
    }

    public Question01SingleChoice(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Question01SingleChoice(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
