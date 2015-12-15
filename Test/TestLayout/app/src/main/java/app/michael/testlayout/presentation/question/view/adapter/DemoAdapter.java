package app.michael.testlayout.presentation.question.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import app.michael.testlayout.presentation.question.model.DemoItem;
import app.michael.testlayout.R;

/**
 * Created by michael on 11/28/15.
 */
public class DemoAdapter extends ArrayAdapter<DemoItem> {
    private List<DemoItem> items;

    private LayoutInflater layoutInflater;

    public DemoAdapter(Context context,List<DemoItem> items) {
        super(context, 0,items);
        layoutInflater = LayoutInflater.from(context);

        this.items = items;
    }

    public List<DemoItem> getItems() {
        return items;
    }

    public void setItems(List<DemoItem> items) {
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.demo_item,parent,false);

        TextView textView = (TextView)view.findViewById(R.id.text_item);

        textView.setText(Integer.toString(items.get(position).getPosition()));

        return  view;

    }
}
