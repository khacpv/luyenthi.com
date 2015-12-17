package com.lt.app.screens.question.views;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.lt.app.R;
import com.lt.app.common.view.textview.ResourceImageGetter;
import com.lt.app.common.util.StringUtils;
import com.lt.app.common.util.ToastUtils;
import com.lt.app.common.view.BaseHeader;
import com.lt.app.common.view.question.QuestionLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/**
 * Created by khacpham on 12/16/15.
 * Display question with single choice. With image or not
 */
public class Question01SingleChoice extends QuestionLayout implements View.OnClickListener {
    public static final String TAG = Question01SingleChoice.class.getSimpleName();

    public BaseHeader header;
    public TextView tvQuestionTitle, tvQuestionContent, tvQuestion, tvAnswerA, tvAnswerB, tvAnswerC, tvAnswerD;
    public SlidingUpPanelLayout sliding_layout;
    public LinearLayout lyAnswer, lyAnswerA, lyAnswerB, lyAnswerC, lyAnswerD;
    public ImageView imvSlide;
    public ScrollView scollviewQuestion;
    public ViewSwitcher viewSwitcher;


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

    protected void init() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.question_layout_01_singlechoice, this, true);
        header = (BaseHeader) v.findViewById(R.id.header);
        tvQuestionTitle = (TextView) v.findViewById(R.id.tvQuestionTitle);
        tvQuestionContent = (TextView) v.findViewById(R.id.tvQuestionContent);
        tvQuestion = (TextView) v.findViewById(R.id.tvQuestion);
        tvAnswerA = (TextView) v.findViewById(R.id.tvAnswerA);
        tvAnswerB = (TextView) v.findViewById(R.id.tvAnswerB);
        tvAnswerC = (TextView) v.findViewById(R.id.tvAnswerC);
        tvAnswerD = (TextView) v.findViewById(R.id.tvAnswerD);
        sliding_layout = (SlidingUpPanelLayout) v.findViewById(R.id.sliding_layout);
        lyAnswer = (LinearLayout) v.findViewById(R.id.lyAnswer);
        lyAnswerA = (LinearLayout) v.findViewById(R.id.lyAnswerA);
        lyAnswerB = (LinearLayout) v.findViewById(R.id.lyAnswerB);
        lyAnswerC = (LinearLayout) v.findViewById(R.id.lyAnswerC);
        lyAnswerD = (LinearLayout) v.findViewById(R.id.lyAnswerD);
        imvSlide = (ImageView) v.findViewById(R.id.imvSlide);

        lyAnswerA.setOnClickListener(this);
        lyAnswerB.setOnClickListener(this);
        lyAnswerC .setOnClickListener(this);
        lyAnswerD .setOnClickListener(this);

        viewSwitcher= (ViewSwitcher) v.findViewById(R.id.viewSwitcher);
      /*  viewSwitcher.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewSwitcher switcher = (ViewSwitcher) v;

                if (switcher.getDisplayedChild() == 0) {
                    switcher.showNext();
                } else {
                    switcher.showPrevious();
                }
            }
        });*/

        String html = (StringUtils.getStringFromResouce(getContext(), R.string.question_long));

        tvQuestionContent.setText(Html.fromHtml(html, new ResourceImageGetter(getContext()), null));
        tvQuestionContent.setMovementMethod(LinkMovementMethod.getInstance());
        scollviewQuestion= (ScrollView) v.findViewById(R.id.scollviewQuestion);

        sliding_layout.setPressed(false);
        sliding_layout.setCoveredFadeColor(getResources().getColor(R.color.white_tran));
        sliding_layout.setPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.e(TAG, "panel slide");
            }

            @Override
            public void onPanelCollapsed(View panel) {
                Log.e(TAG, "panel Collapse");
              // imvSlide.setImageResource(R.drawable.arrow_up);
                viewSwitcher.showNext();
            }

            @Override
            public void onPanelExpanded(View panel) {
                Log.e(TAG, "panel Expand");
             //   imvSlide.setImageResource(R.drawable.arrow_down);
                viewSwitcher.showNext();
            }

            @Override
            public void onPanelAnchored(View panel) {
                Log.e(TAG, "panel onPanelAnchored");
            }

            @Override
            public void onPanelHidden(View panel) {
                Log.e(TAG, "panel onPanelHidden");
            }
        });

        sliding_layout.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scollviewQuestion.onTouchEvent(event);
                return false;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lyAnswerA:
                ToastUtils.showToast(getContext(), "You choose A", false);
                break;

            case R.id.lyAnswerB:
                ToastUtils.showToast(getContext(), "You choose B", false);
                break;

            case R.id.lyAnswerC:
                ToastUtils.showToast(getContext(), "You choose C", false);
                break;

            case R.id.lyAnswerD:
                ToastUtils.showToast(getContext(), "You choose D", false);
                break;
        }
    }
}
