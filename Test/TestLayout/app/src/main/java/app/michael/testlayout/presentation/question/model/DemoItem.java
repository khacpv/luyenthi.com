package app.michael.testlayout.presentation.question.model;

import android.annotation.SuppressLint;
import android.os.Parcel;

import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;

import org.w3c.dom.ProcessingInstruction;

/**
 * Created by michael on 11/28/15.
 */
@SuppressLint("ParcelCreator")
public class DemoItem implements AsymmetricItem {
    private int colSpan;
    private int rowSpan;
    private int position;

    public DemoItem(int colSpan,int rowSpan,int position) {
        this.colSpan = colSpan;
        this.position = position;
        this.rowSpan = rowSpan;
    }

    @Override
    public int getColumnSpan() {
        return colSpan;
    }

    @Override
    public int getRowSpan() {
        return rowSpan;
    }

    public int getPosition() {
        return  position;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
