package com.lt.app.screens.question.views;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lt.app.R;
import com.lt.app.common.util.DimenUtils;
import com.lt.app.common.view.flowlayout.FlowLayout;
import com.lt.app.common.view.flowlayout.MultiLineFlowLayout;
import com.lt.app.common.view.question.QuestionLayout;
import com.lt.app.common.view.tag.TextViewTag;

import java.util.ArrayList;

/**
 * Created by khacpham on 12/16/15.
 * Display question with fill answer into blank space. have answers to choice
 */
public class Question04FillBlankSpaceWithAnswer extends QuestionLayout implements View.OnClickListener {

    TextView tvTitle;
    TextView tvContent;
    MultiLineFlowLayout flowAnswer;
    FlowLayout flowTag;

    TextViewTag tag01;
    TextViewTag tag02;
    TextViewTag tag03;
    TextViewTag tag04;


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

        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvContent = (TextView)findViewById(R.id.tvContent);

        flowAnswer = (MultiLineFlowLayout)findViewById(R.id.flowAnswer);
        flowTag = (FlowLayout)findViewById(R.id.flowTag);

        tag01 = new TextViewTag(getContext());
        tag02 = new TextViewTag(getContext());
        tag03 = new TextViewTag(getContext());
        tag04 = new TextViewTag(getContext());

        tag01.setText("+ adj/adv").setTag(0);
        tag02.setText("+ too").setTag(1);
        tag03.setText("+ (for someone)").setTag(2);
        tag04.setText("+ to do something").setTag(3);

        flowAnswer.setLayoutTransition(new LayoutTransition());
        flowTag.setLayoutTransition(new LayoutTransition());

        flowTag.removeAllViews();
        flowAnswer.removeAllViews();

        addTagView(flowTag,tag01,-1,20);
        addTagView(flowTag, tag02, -1, 20);
        addTagView(flowTag, tag03, -1, 20);
        addTagView(flowTag, tag04, -1, 20);
    }

    @Override
    public void onClick(final View v) {
        if(!(v instanceof TextViewTag)){
            return;
        }
        TextViewTag tvTag = (TextViewTag) v;
        if(((ViewGroup)v.getParent()).getId() == flowTag.getId()) {
            flowTag.removeView(tvTag);
            TextViewTag newTag = new TextViewTag(getContext());
            newTag.setText(tvTag.getText()).setTag(tvTag.getTag());
            addTagView(flowAnswer, newTag, -1, 0);
        }else{
            flowAnswer.removeView(tvTag);
            TextViewTag newTag = new TextViewTag(getContext());
            newTag.setText(tvTag.getText()).setTag(tvTag.getTag());
            addTagView(flowTag, newTag, (int)tvTag.getTag(), 20);
        }
    }

    private void addTagView(FlowLayout layout,TextViewTag tag,int index,int marginRight){
        if(index<0) {
            layout.addView(tag);
        }else{
            layout.addView(tag,Math.min(index,layout.getChildCount()));
        }
        tag.setOnClickListener(this);
        tag.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        tag.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        ((FlowLayout.LayoutParams)tag.getLayoutParams()).rightMargin = DimenUtils.dpToPx(getContext(),marginRight);
    }
}
