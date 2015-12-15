package app.michael.testlayout.presentation.question.view.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

import app.michael.testlayout.R;
import app.michael.testlayout.presentation.question.model.DemoItem;
import app.michael.testlayout.presentation.question.model.GridObject;
import app.michael.testlayout.presentation.question.view.adapter.DemoAdapter;
import app.michael.testlayout.presentation.question.view.adapter.GridCellAdapter;
import app.michael.testlayout.presentation.question.view.presenter.IQuestionPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;


public class QuestionContentFragment extends Fragment {
    @Bind(R.id.asym_grid_content) AsymmetricGridView gridViewContent;

    private IQuestionPresenter presenter;

    private GridObject questionContent;

    public QuestionContentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_question_content, container, false);

        ButterKnife.bind(this, view);

        questionContent = presenter.getQuestionContent();

        gridViewContent.setRequestedColumnCount(2);

        GridCellAdapter adapter = new GridCellAdapter(getActivity(),questionContent.getCells());

        gridViewContent.setAdapter(new AsymmetricGridViewAdapter(getActivity(), gridViewContent, adapter));

        return  view;
    }

    public IQuestionPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(IQuestionPresenter presenter) {
        this.presenter = presenter;
    }
}
