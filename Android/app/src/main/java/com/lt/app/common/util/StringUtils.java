package com.lt.app.common.util;

import android.content.Context;

import com.lt.app.R;

/**
 * Created by khacpham on 12/15/15.
 */
public class StringUtils {

    public static String getStringFromResouce(Context mContext, int id) {
        return mContext.getResources().getString(id);
    }
}
