package app.michael.testlayout.presentation.question.view.presenter;

import app.michael.testlayout.presentation.question.model.GridObject;
import app.michael.testlayout.presentation.question.model.QuestionEntity;

/**
 * Created by michael on 11/28/15.
 */
public interface IQuestionPresenter {
    GridObject getQuestionContent();
    GridObject getAnswerPresentationData();
    GridObject getAnswerList();
    void verifyAnswers();
    void goNext();
    void goPrevious();
}
