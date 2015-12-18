package com.lt.app.screens.question.views;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;

import com.lt.app.R;
import com.lt.app.common.view.question.QuestionLayout;
import com.lt.app.common.view.textview.ResourceTagHandler;
import com.lt.app.common.view.textview.RichTextView;

import org.xml.sax.XMLReader;

import java.util.HashMap;

/**
 * Created by khacpham on 12/16/15.
 * Display question with single choice. With image or not
 */
public class Question05SortAnswer extends QuestionLayout implements ResourceTagHandler.OnClickableListener {
    RichTextView tvContent;

    String html;

    public Question05SortAnswer(Context context) {
        super(context);
        init();
    }

    public Question05SortAnswer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Question05SortAnswer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.question_layout_05_sortanswer,this,true);

        tvContent = (RichTextView)findViewById(R.id.tvQuestionContent);

        html = getResources().getString(R.string.question_short);
        tvContent.setRichText(html);
        tvContent.setOnClickableListener(this);
    }

    @Override
    public void onClick(String element, Editable output, Integer start, HashMap<String,String> attributes) {
        Log.e("TAG","attribute:"+attributes.get("data"));
    }
}
