package app.michael.testlayout.presentation.question.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 11/28/15.
 */
public class QuestionEntity {
    private String title;
    private String content;
    private List<Accessory> accessories;
    private String answerPresentation;
    private List<Answer> answers;


    public QuestionEntity() {
        accessories = new ArrayList<Accessory>();
        answers = new ArrayList<Answer>();
    }
}
