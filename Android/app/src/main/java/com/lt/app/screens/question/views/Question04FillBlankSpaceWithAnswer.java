package com.lt.app.screens.question.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.lt.app.R;
import com.lt.app.common.view.question.QuestionLayout;

/**
 * Created by khacpham on 12/16/15.
 * Display question with fill answer into blank space. have answers to choice
 */
public class Question04FillBlankSpaceWithAnswer extends QuestionLayout {

    public Question04FillBlankSpaceWithAnswer(Context context) {
        super(context);
        init();
    }

    public Question04FillBlankSpaceWithAnswer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Question04FillBlankSpaceWithAnswer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.question_layout_04_fillblankspacewithanswer,this,true);

    }
}
