package com.lt.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.lt.app.screens.question.QuestionActivity;
import com.lt.app.screens.question.views.Question01SingleChoice;
import com.lt.app.screens.question.views.Question01SingleChoiceImage;
import com.lt.app.screens.question.views.Question02MultiChoice;
import com.lt.app.screens.question.views.Question02MultiChoiceImage;
import com.lt.app.screens.question.views.Question03FillBlankSpace;
import com.lt.app.screens.question.views.Question04FillBlankSpaceWithAnswer;
import com.lt.app.screens.question.views.Question05SortAnswer;

/**
 * Start activity.
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void openQuestionActivity(View button){
        Intent questionIntentActivity = new Intent(this, QuestionActivity.class);
        String questionType = "";
        switch (button.getId()){
            case R.id.btnSingleChoice:
                questionType = Question01SingleChoice.class.getSimpleName();
                break;
            case R.id.btnSingleChoiceWithImage:
                questionType = Question01SingleChoiceImage.class.getSimpleName();
                break;
            case R.id.btnMultiChoice:
                questionType = Question02MultiChoice.class.getSimpleName();
                break;
            case R.id.btnMultiChoiceImage:
                questionType = Question02MultiChoiceImage.class.getSimpleName();
                break;
            case R.id.btnFillBlankSpace:
                questionType = Question03FillBlankSpace.class.getSimpleName();
                break;
            case R.id.btnFillBlankSpaceWithAnswer:
                questionType = Question04FillBlankSpaceWithAnswer.class.getSimpleName();
                break;
            case R.id.btnSortAnswer:
                questionType = Question05SortAnswer.class.getSimpleName();
                break;
            default:
                throw new RuntimeException("button don't click any question");
        }
        questionIntentActivity.putExtra(QuestionActivity.ACTION_DATA_TYPE,questionType);
        startActivity(questionIntentActivity);
    }
}
