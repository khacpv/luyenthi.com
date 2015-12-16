package com.lt.app.common.view.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lt.app.R;

/**
 * Created by khacpham on 12/16/15.
 */
public class TextViewTag extends LinearLayout {

    TextView tvTag;

    public TextViewTag(Context context) {
        super(context);
        init(null);
    }

    public TextViewTag(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TextViewTag(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        LayoutInflater.from(getContext()).inflate(R.layout.base_layout_tag,this,true);
        tvTag = (TextView)findViewById(R.id.tvTag);

        if(attrs != null){
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TextViewTag, 0, 0);
            String titleText = a.getString(R.styleable.TextViewTag_text);
            setText(titleText);
            a.recycle();
        }
    }

    public TextViewTag setText(String text){
        tvTag.setText(text);
        return this;
    }

    public String getText(){
        return tvTag.getText().toString();
    }
}
