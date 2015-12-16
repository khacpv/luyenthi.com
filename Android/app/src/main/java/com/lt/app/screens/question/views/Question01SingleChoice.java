package com.lt.app.screens.question.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.lt.app.R;
import com.lt.app.common.view.question.QuestionLayout;

/**
 * Created by khacpham on 12/16/15.
 * Display question with single choice. With image or not
 */
public class Question01SingleChoice extends QuestionLayout {
    public static final String TAG = Question01SingleChoice.class.getName();

    public Question01SingleChoice(Context context) {

        super(context);
        init();
    }

    public Question01SingleChoice(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Question01SingleChoice(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    void init() {
            View v= LayoutInflater.from(getContext()).inflate(R.layout.question_layout_01_singlechoice,this,true);


    }
}
