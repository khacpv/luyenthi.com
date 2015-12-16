package com.lt.app.common.view.textview;

import android.content.Context;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import com.lt.app.R;

import org.xml.sax.XMLReader;

/**
 * Created by khacpham on 12/16/15.
 */
public class ResourceTagHandler implements Html.TagHandler {
    private Context context;
    int highlightStart = 0;
    int answerStart = 0;

    private OnAnswerClickListener listener;

    public ResourceTagHandler(Context ctx){
        this.context = ctx;
    }

    public ResourceTagHandler setOnAnswerClickListener(OnAnswerClickListener listener){
        this.listener = listener;
        return this;
    }

    @Override
    public void handleTag(boolean opening, final String tag, final Editable output, final XMLReader xmlReader) {
        if("lt_highlight".equalsIgnoreCase(tag)){
            if(opening) {
                highlightStart = output.length();
            }else{
                int colorHighLight = context.getResources().getColor(R.color.colorHighlight);
                output.setSpan(new ForegroundColorSpan(colorHighLight), highlightStart, output.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        if("lt_answer".equalsIgnoreCase(tag)){
            if(opening) {
                answerStart = output.length();
            }else{
                final Integer _answerStart = answerStart;
                int colorBlank = context.getResources().getColor(R.color.colorBlank);
                output.setSpan(new BackgroundColorSpan(colorBlank), _answerStart, output.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                output.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        if(listener != null){
                            listener.onClick(tag,output,_answerStart,output.length(),xmlReader);
                        }
                    }
                }, answerStart, output.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                int colorHighLight = context.getResources().getColor(R.color.colorHighlight);
                output.setSpan(new ForegroundColorSpan(colorHighLight), answerStart, output.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    public interface OnAnswerClickListener{
        void onClick(String tag, Editable output,Integer start,Integer end,XMLReader xmlReader);
    }
}
