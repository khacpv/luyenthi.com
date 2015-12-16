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

    TextViewTag tagDummy01;
    TextViewTag tagDummy02;
    TextViewTag tagDummy03;

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

        tagDummy01 = (TextViewTag)findViewById(R.id.tagDummy01);
        tagDummy02 = (TextViewTag)findViewById(R.id.tagDummy02);
        tagDummy03 = (TextViewTag)findViewById(R.id.tagDummy03);

        tag01 = new TextViewTag(getContext());
        tag02 = new TextViewTag(getContext());
        tag03 = new TextViewTag(getContext());
        tag04 = new TextViewTag(getContext());

        flowAnswer.setLayoutTransition(new LayoutTransition());
        flowTag.setLayoutTransition(new LayoutTransition());
        flowTag.removeAllViews();

        addTagView(flowTag,tag01,-1,20);
        addTagView(flowTag, tag02, -1, 20);
        addTagView(flowTag, tag03, -1, 20);
        addTagView(flowTag, tag04, -1, 20);

        tag01.setOnClickListener(this);
        tag02.setOnClickListener(this);
        tag03.setOnClickListener(this);
        tag04.setOnClickListener(this);

        tag01.setText("+ adj/adv");
        tag02.setText("+ too");
        tag03.setText("+ (for someone)");
        tag04.setText("+ to do something");
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
            newTag.setText(tvTag.getText());
            addTagView(flowAnswer, newTag, 0, 0);
        }else{
            flowAnswer.removeView(tvTag);

            TextViewTag newTag = new TextViewTag(getContext());
            newTag.setText(tvTag.getText());
            addTagView(flowTag, newTag, -1, 20);
        }
        invalidateDummyView();
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                invalidateDummyView();
            }
        },0);

    }

    private void addTagView(FlowLayout layout,TextViewTag tag,int index,int marginRight){
        if(index<0) {
            layout.addView(tag);
        }else{
            layout.addView(tag,index);
        }
        tag.setOnClickListener(this);
        tag.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        tag.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        ((FlowLayout.LayoutParams)tag.getLayoutParams()).rightMargin = DimenUtils.dpToPx(getContext(),marginRight);
    }

    private void invalidateDummyView(){
        int lineCount = flowAnswer.getLineCount();

        Log.e("LINE COUNT","LINE COUNT "+lineCount);
        if(lineCount == 0){
            tagDummy01.setVisibility(View.INVISIBLE);
            tagDummy02.setVisibility(View.INVISIBLE);
            tagDummy03.setVisibility(View.INVISIBLE);
        }
        if(lineCount == 1){
            tagDummy01.setVisibility(View.GONE);
            tagDummy02.setVisibility(View.INVISIBLE);
            tagDummy03.setVisibility(View.INVISIBLE);
        }
        if(lineCount == 2){
            tagDummy01.setVisibility(View.GONE);
            tagDummy02.setVisibility(View.GONE);
            tagDummy03.setVisibility(View.INVISIBLE);
        }
        if(lineCount >2){
            tagDummy01.setVisibility(View.GONE);
            tagDummy02.setVisibility(View.GONE);
            tagDummy03.setVisibility(View.GONE);
        }
        flowAnswer.requestLayout();
        flowAnswer.invalidate();
    }
}
