package com.lt.app.screens.question.views;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.text.Editable;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.lt.app.R;
import com.lt.app.common.util.DimenUtils;
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
 * @see https://leons.im/posts/how-to-get-coordinate-of-a-clickablespan-inside-a-textview/
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

    TextView tvAnswerAnim;

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
        tvAnswerAnim = (TextView)findViewById(R.id.tvAnswerAnim);

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
    public void onClick(String content, Editable output,Integer start,HashMap<String,String> attributes) {
        String att=attributes.get("data");
        String attribute = String.format("<lt_clickable data=%s>%s</lt_clickable>", att, content);

        String newAttribute = String.format("<lt_clickable data=%s>.....</lt_clickable>", att);

        String newHtml = html.replaceFirst(attribute,newAttribute);
        if(!newHtml.equalsIgnoreCase(html) && att.contains("answer:")){
            html = newHtml;
            tvQuestionContent.setRichText(html);

            TextView tv = (TextView)LayoutInflater.from(getContext()).inflate(R.layout.textview_tag, null,false);
            tv.setText(content);
            tv.setOnClickListener(this);
            flowAnswer.addView(tv);
            ((FlowLayout.LayoutParams)tv.getLayoutParams()).width = ViewGroup.LayoutParams.WRAP_CONTENT;
            ((FlowLayout.LayoutParams)tv.getLayoutParams()).height = ViewGroup.LayoutParams.WRAP_CONTENT;
            ((FlowLayout.LayoutParams) tv.getLayoutParams()).bottomMargin= DimenUtils.dpToPx(getContext(),5);
            ((FlowLayout.LayoutParams)tv.getLayoutParams()).rightMargin= DimenUtils.dpToPx(getContext(),5);
        }
    }

    @Override
    public void onClick(final View v) {
        if(v instanceof TextView) {
            TextView tv = (TextView)v;
            String newHtml = html.replaceFirst("\\.\\.\\.\\.\\.", tv.getText().toString());
            if(!newHtml.equalsIgnoreCase(html)) {
                html = newHtml;
                Point newCood = tvQuestionContent.getFirstPosThreeDot();

                int[] fromCood = new int[2];
                v.getLocationOnScreen(fromCood);
                tvAnswerAnim.setX(fromCood[0]);
                tvAnswerAnim.setY(fromCood[1]);
                tvAnswerAnim.setText(tv.getText());
                tvAnswerAnim.setVisibility(View.VISIBLE);
                Log.e("TAG","cood y:"+newCood.y+ " x:"+newCood.x);
                flowAnswer.removeView(v);

                tvAnswerAnim.animate().x(newCood.x-tvAnswerAnim.getWidth()/2).y(newCood.y-tvAnswerAnim.getHeight()).setDuration(500).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        tvAnswerAnim.setVisibility(View.GONE);
                        tvQuestionContent.setRichText(html);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();

            }else{
                ToastUtils.showToast(getContext(), "out of range", false);
            }
        }
    }
}
