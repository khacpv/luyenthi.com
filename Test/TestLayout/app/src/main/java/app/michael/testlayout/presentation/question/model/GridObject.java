package app.michael.testlayout.presentation.question.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 11/28/15.
 */
public class GridObject {
    private int num_cols=0;
    private int num_rows =0;
    private List<GridCell> cells;

    public GridObject() {
        cells = new ArrayList<GridCell>();
    }

    public GridObject(List<GridCell> cells) {
        this.setCells(cells);
    }

    public List<GridCell> getCells() {
        return cells;
    }

    public void setCells(List<GridCell> cells) {
        this.cells = cells;
    }

    public int getNum_cols() {
        return num_cols;
    }

    public void setNum_cols(int num_cols) {
        this.num_cols = num_cols;
    }

    public int getNum_rows() {
        return num_rows;
    }

    public void setNum_rows(int num_rows) {
        this.num_rows = num_rows;
    }
}
