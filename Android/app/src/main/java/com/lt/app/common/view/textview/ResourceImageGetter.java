package com.lt.app.common.view.textview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

import com.lt.app.BuildConfig;
import com.lt.app.R;

/**
 * Created by eo_cuong on 12/16/15.
 */
public class ResourceImageGetter implements Html.ImageGetter {
    private final Context context;

    public ResourceImageGetter(Context context) {
        this.context = context;
    }

    @Override
    public Drawable getDrawable(String source) {
        int path=0;
        if(source.equals("icon_info/")){
            path=R.drawable.icon_info;
            Drawable drawable = context.getResources().getDrawable(path);
            drawable.setBounds(10, 10, drawable.getIntrinsicWidth()/3,drawable.getIntrinsicHeight()/3);
            return drawable;
        }
        if(source.equalsIgnoreCase("icon_fomular/")){
            path = R.drawable.icon_fomular;
            Drawable drawable = context.getResources().getDrawable(path);
            drawable.setBounds(10, 10, drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
            return drawable;
        }
        path=R.drawable.icon_info;
        Drawable drawable = context.getResources().getDrawable(path);
        drawable.setBounds(10, 10, drawable.getIntrinsicWidth()/3,drawable.getIntrinsicHeight()/3);
        return drawable;
    }
}
