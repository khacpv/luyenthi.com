package com.lt.app.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by khacpham on 12/16/15.
 */
public class DimenUtils {

    public static float dpToPx(Context ctx,float dp){
        Resources r = ctx.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return px;
    }

    public static float pxToDp(float px){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return Math.round(dp);
    }

    public static int dpToPx(Context ctx,int dp){
        return Math.round(dp*(ctx.getResources().getDisplayMetrics().xdpi/DisplayMetrics.DENSITY_DEFAULT));

    }

    public static int pxToDp(int px){
        return Math.round(px/(Resources.getSystem().getDisplayMetrics().xdpi/DisplayMetrics.DENSITY_DEFAULT));
    }
}
