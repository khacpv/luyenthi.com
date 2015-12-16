package com.lt.app.common.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by eo_cuong on 12/16/15.
 */
public class ToastUtils {

    public static void showToast(Context context, String msg, boolean islong) {
        Toast.makeText(context, msg, islong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }
}
