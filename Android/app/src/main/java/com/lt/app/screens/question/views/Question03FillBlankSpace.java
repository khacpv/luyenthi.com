package com.lt.app.screens.question.views;

import android.animation.LayoutTransition;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lt.app.R;
import com.lt.app.common.util.ToastUtils;
import com.lt.app.common.util.StringUtils;
import com.lt.app.common.view.flowlayout.FlowLayout;
import com.lt.app.common.view.question.QuestionLayout;
import com.lt.app.common.view.textview.ResourceTagHandler;
import com.lt.app.common.view.textview.RichTextView;

import org.xml.sax.XMLReader;

import java.util.HashMap;

/**
 * Created by khacpham on 12/16/15.
 * Display question with fill answer into blank space.
 */
public class Question03FillBlankSpace extends QuestionLayout implements ResourceTagHandler.OnClickableListener, View.OnClickListener {

    RichTextView tvQuestionContent;

    TextView tvAnswer01;
    TextView tvAnswer02;
    TextView tvAnswer03;
    TextView tvAnswer04;
    TextView tvAnswer05;
    TextView tvAnswer06;
    TextView tvAnswer07;
    TextView tvAnswer08;

    String html;

    int currentAnswerPos=0;

    FlowLayout flowAnswer;

    public Question03FillBlankSpace(Context context) {
        super(context);
        init();
    }

    public Question03FillBlankSpace(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Question03FillBlankSpace(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.question_layout_03_fillblankspace,this,true);

        tvQuestionContent = (RichTextView)findViewById(R.id.tvQuestionContent);
        flowAnswer = (FlowLayout)findViewById(R.id.flowAnswer);
        tvAnswer01 = (TextView)findViewById(R.id.tvAnswer01);
        tvAnswer02 = (TextView)findViewById(R.id.tvAnswer02);
        tvAnswer03 = (TextView)findViewById(R.id.tvAnswer03);
        tvAnswer04 = (TextView)findViewById(R.id.tvAnswer04);
        tvAnswer05 = (TextView)findViewById(R.id.tvAnswer05);
        tvAnswer06 = (TextView)findViewById(R.id.tvAnswer06);
        tvAnswer07 = (TextView)findViewById(R.id.tvAnswer07);
        tvAnswer08 = (TextView)findViewById(R.id.tvAnswer08);

        tvAnswer01.setOnClickListener(this);
        tvAnswer02.setOnClickListener(this);
        tvAnswer03.setOnClickListener(this);
        tvAnswer04.setOnClickListener(this);
        tvAnswer05.setOnClickListener(this);
        tvAnswer06.setOnClickListener(this);
        tvAnswer07.setOnClickListener(this);
        tvAnswer08.setOnClickListener(this);
        tvQuestionContent.setOnClickableListener(this);

        html = (StringUtils.getStringFromResouce(getContext(), R.string.question_03_content));
        tvQuestionContent.setRichText(html);

        flowAnswer.setLayoutTransition(new LayoutTransition());
    }

    @Override
    public void onClick(String tag, Editable output,Integer start,HashMap<String,String> attributes) {
        ToastUtils.showToast(getContext(),"tag:"+tag+":"+attributes.get("data"),false);
        String att=attributes.get("data");
        if(att.equalsIgnoreCase("answer:dap_an")){
            TextView tv = new TextView(getContext());
            tv.setText("Dap An");
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            flowAnswer.addView(tv);
            ((FlowLayout.LayoutParams)tv.getLayoutParams()).bottomMargin=5;
            ((FlowLayout.LayoutParams)tv.getLayoutParams()).rightMargin=5;
        }
    }

    @Override
    public void onClick(View v) {
        html.replace("Suddenly", "Dap An");
        tvQuestionContent.setRichText(html);
        flowAnswer.removeView(v);
    }
}
