package com.lt.app.screens.question.views;

import android.content.Context;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lt.app.R;
import com.lt.app.common.util.ToastUtils;
import com.lt.app.common.util.StringUtils;
import com.lt.app.common.view.question.QuestionLayout;
import com.lt.app.common.view.textview.ResourceTagHandler;
import com.lt.app.common.view.textview.RichTextView;

import org.xml.sax.XMLReader;

/**
 * Created by khacpham on 12/16/15.
 * Display question with fill answer into blank space.
 */
public class Question03FillBlankSpace extends QuestionLayout implements ResourceTagHandler.OnAnswerClickListener, View.OnClickListener {

    RichTextView tvQuestionContent;

    TextView tvAnswer01;

    String html;

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
        tvAnswer01 = (TextView)findViewById(R.id.tvAnswer01);

        tvAnswer01.setOnClickListener(this);
        tvQuestionContent.setOnAnswerClickListener(this);

        html = (StringUtils.getStringFromResouce(getContext(), R.string.question_03_content));
        tvQuestionContent.setRichText(html);
    }

    @Override
    public void onClick(String tag, Editable output,Integer start,Integer end, XMLReader xmlReader) {
        ToastUtils.showToast(getContext(),"tag:"+tag+":"+output.subSequence(start,start+6),false);
    }

    @Override
    public void onClick(View v) {
        Object[] objects = tvQuestionContent.span().getSpans(33, 33 + 6, Object.class);
        for(Object obj: objects){
            Log.e("SPANN","class:"+obj.getClass().getSimpleName());

        }
    }
}
