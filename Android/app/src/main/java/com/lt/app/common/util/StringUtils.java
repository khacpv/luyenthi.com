package com.lt.app.common.util;

import android.content.Context;
import android.text.Html;

import com.lt.app.R;

/**
 * Created by khacpham on 12/15/15.
 */
public class StringUtils {

    public static String getStringFromResouce(Context mContext, int id) {
        return mContext.getResources().getString(id);
    }

    public static CharSequence stripHtml(String s) {
        return Html.fromHtml(s).toString().replace('\n', (char) 32)
                .replace((char) 160, (char) 32).replace((char) 65532, (char) 32).trim();
    }

    public static int countMatch(String input,String match){
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = input.indexOf(match,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += match.length();
            }
        }
        return count;
    }
}
