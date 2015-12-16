package com.lt.app.screens.question;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.lt.app.R;
import com.lt.app.common.view.question.QuestionLayout;
import com.lt.app.screens.question.views.Question01SingleChoice;
import com.lt.app.screens.question.views.Question01SingleChoiceImage;
import com.lt.app.screens.question.views.Question02MultiChoice;
import com.lt.app.screens.question.views.Question02MultiChoiceImage;
import com.lt.app.screens.question.views.Question03FillBlankSpace;
import com.lt.app.screens.question.views.Question04FillBlankSpaceWithAnswer;
import com.lt.app.screens.question.views.Question05SortAnswer;

/**
 * Created by khacpham on 12/15/15.
 */
public class QuestionActivity extends AppCompatActivity {
    public static final String TAG = QuestionActivity.class.getName();

    public static final String ACTION_FILTER = "com.lt.app.screen.question";    // must be match in Manifest.xml
    public static final String ACTION_DATA_TYPE = "lt.question.type";

    private QuestionLayout questionLayout;

    private FrameLayout container;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hideActionBar();

        setContentView(R.layout.question_activity);
        container = (FrameLayout)findViewById(R.id.container);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null || !bundle.containsKey(ACTION_DATA_TYPE)){
            finish();
        }

        // get arguments
        String questionType = bundle.getString(ACTION_DATA_TYPE);
        switch (questionType){
            case "Question01SingleChoice":
                questionLayout = new Question01SingleChoice(this);
                break;
            case "Question01SingleChoiceImage":
                questionLayout = new Question01SingleChoiceImage(this);
                break;
            case "Question02MultiChoice":
                questionLayout = new Question02MultiChoice(this);
                break;
            case "Question02MultiChoiceImage":
                questionLayout = new Question02MultiChoiceImage(this);
                break;
            case "Question03FillBlankSpace":
                questionLayout = new Question03FillBlankSpace(this);
                break;
            case "Question04FillBlankSpaceWithAnswer":
                questionLayout = new Question04FillBlankSpaceWithAnswer(this);
                break;
            case "Question05SortAnswer":
                questionLayout = new Question05SortAnswer(this);
                break;
            default:
                throw  new RuntimeException("indicate a question type");

        }
        refresh();
    }

    private void refresh(){
        container.removeAllViews();
        container.addView(questionLayout);
    }

    private void hideActionBar(){
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar != null){
            supportActionBar.hide();
        }

        android.app.ActionBar actionBar = getActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }
}
