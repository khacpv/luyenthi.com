package app.michael.testlayout.presentation.question.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.michael.testlayout.R;

public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment QuestionFragment.
     */
    public static QuestionFragment newInstance() {
        QuestionFragment fragment = new QuestionFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }
}
