package app.michael.testlayout.presentation.question.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import app.michael.testlayout.R;
import app.michael.testlayout.presentation.question.view.fragment.QuestionContentFragment;
import app.michael.testlayout.presentation.question.view.presenter.IQuestionPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class QuestionActivity extends AppCompatActivity {

    @Bind(R.id.frame_question_content) FrameLayout frame_main_content;

    private IQuestionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ButterKnife.bind(this);

        //presenter = new QuestionPresenter(this);

        //QuestionContentFragment questionFragment = new QuestionContentFragment();
        //questionFragment.setPresenter(presenter);

        //displayFragment(questionFragment);

    }

    public void displayFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_question_content,fragment);
        transaction.commit();
    }

}
