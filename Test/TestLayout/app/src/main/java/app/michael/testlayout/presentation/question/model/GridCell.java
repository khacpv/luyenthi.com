package app.michael.testlayout.presentation.question.model;

import android.annotation.SuppressLint;
import android.os.Parcel;

import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

/**
 * Created by michael on 11/28/15.
 */
@SuppressLint("ParcelCreator")
public class GridCell implements AsymmetricItem {
    private int col_span;
    private int row_span;

    private CellData cellData;

    public GridCell() {
        cellData = new CellData();
    }

    public GridCell(int col_span, int row_span, CellData cellData) {
        this.col_span = col_span;
        this.row_span = row_span;
        this.cellData = cellData;
    }

    @Override
    public int getColumnSpan() {
        return col_span;
    }

    @Override
    public int getRowSpan() {
        return row_span;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public CellData getCellData() {
        return cellData;
    }

    public void setCellData(CellData cellData) {
        this.cellData = cellData;
    }
}
