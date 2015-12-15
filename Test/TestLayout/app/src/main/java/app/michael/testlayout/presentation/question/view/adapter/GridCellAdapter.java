package app.michael.testlayout.presentation.question.view.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import app.michael.testlayout.R;
import app.michael.testlayout.presentation.question.model.DemoItem;
import app.michael.testlayout.presentation.question.model.GridCell;

/**
 * Created by michael on 11/30/15.
 */
public class GridCellAdapter extends ArrayAdapter<GridCell> {
    private List<GridCell> items;

    private LayoutInflater layoutInflater;

    public GridCellAdapter(Context context,List<GridCell> items) {
        super(context, 0,items);
        layoutInflater = LayoutInflater.from(context);

        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.demo_item,parent,false);

        TextView textView = (TextView)view.findViewById(R.id.text_item);

        textView.setText(Html.fromHtml(items.get(position).getCellData().getData()));

        return  view;
    }
}
