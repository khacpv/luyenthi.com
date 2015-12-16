package com.lt.app.common.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

import com.lt.app.BuildConfig;
import com.lt.app.R;

/**
 * Created by eo_cuong on 12/16/15.
 */
public class ResouroceImageGetter implements Html.ImageGetter {
    private final Context context;

    public ResouroceImageGetter(Context context) {
        this.context = context;
    }

    @Override
    public Drawable getDrawable(String source) {
        int path=0;
        if(source.equals("icon_info/")){
            path=R.drawable.icon_info;
        }



        Drawable drawable = context.getResources().getDrawable(path);
        drawable.setBounds(10, 10, drawable.getIntrinsicWidth()/3,
                drawable.getIntrinsicHeight()/3);
        return drawable;
    }
}
