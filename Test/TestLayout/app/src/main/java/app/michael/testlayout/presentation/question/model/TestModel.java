package app.michael.testlayout.presentation.question.model;

/**
 * Created by michael on 12/2/15.
 */
public class TestModel {
    public TestModel(int col_span, int row_span) {
        this.col_span = col_span;
        this.row_span = row_span;
    }

    private int col_span;
    private int row_span;


    public int getCol_span() {
        return col_span;
    }

    public void setCol_span(int col_span) {
        this.col_span = col_span;
    }

    public int getRow_span() {
        return row_span;
    }

    public void setRow_span(int row_span) {
        this.row_span = row_span;
    }
}
