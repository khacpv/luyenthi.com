package com.lt.app.common.view.notedlayout;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lt.app.R;
import com.lt.app.common.util.StringUtils;

/**
 * Created by khacpham on 12/19/15.
 */
public class NotedLayout extends FrameLayout {
    TextView tvTitle;
    TextView tvContent;


    public NotedLayout(Context context) {
        super(context);
        init();
    }

    public NotedLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NotedLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.base_layout_noted, this, true);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvContent = (TextView)findViewById(R.id.tvContent);
    }

    public void setData(String title,String content){
        tvTitle.setText(StringUtils.stripHtml(title));
        tvContent.setText(content);
    }
}
