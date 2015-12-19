package com.lt.app.common.view.textview;

import android.content.Context;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lt.app.R;
import com.lt.app.common.util.ToastUtils;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by khacpham on 12/16/15.
 */
public class ResourceTagHandler implements Html.TagHandler {
    private Context context;
    int highlightStart = 0;
    int answerStart = 0;

    final HashMap<String, String> attributes = new HashMap<>();

    int clickableStart = 0;
    String data = "";

    private OnClickableListener listener;

    public ResourceTagHandler(Context ctx){
        this.context = ctx;
    }

    public ResourceTagHandler setOnClickableListener(OnClickableListener listener){
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

                int colorHighLight = context.getResources().getColor(R.color.colorHighlight);
                output.setSpan(new ForegroundColorSpan(colorHighLight), _answerStart, output.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        if("lt_clickable".equalsIgnoreCase(tag)){
            if(opening) {
                clickableStart = output.length();
                processAttributes(xmlReader);
            }else{
                final Integer _clickableStart = clickableStart;
                final HashMap<String,String> _attributes = new HashMap<>(attributes);
                ClickableSpan clickableSpan = new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        if(listener != null){
                            TextView tv = (TextView) widget;
                            // TODO add check if tv.getText() instanceof Spanned
                            Spanned s = (Spanned) tv.getText();
                            int start = s.getSpanStart(this);
                            int end = s.getSpanEnd(this);
                            String content = s.subSequence(start,end).toString();

                            listener.onClick(content,output,_clickableStart,_attributes);
                        }
                    }
                };
                output.setSpan(clickableSpan, _clickableStart, output.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                int colorHighLight = context.getResources().getColor(R.color.colorClickable);
                output.setSpan(new ForegroundColorSpan(colorHighLight), _clickableStart, output.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            }
        }
    }

    public HashMap<String, String> processAttributes(final XMLReader xmlReader) {
        try {
            Field elementField = xmlReader.getClass().getDeclaredField("theNewElement");
            elementField.setAccessible(true);
            Object element = elementField.get(xmlReader);
            Field attsField = element.getClass().getDeclaredField("theAtts");
            attsField.setAccessible(true);
            Object atts = attsField.get(element);
            Field dataField = atts.getClass().getDeclaredField("data");
            dataField.setAccessible(true);
            String[] data = (String[])dataField.get(atts);
            Field lengthField = atts.getClass().getDeclaredField("length");
            lengthField.setAccessible(true);
            int len = (Integer)lengthField.get(atts);

            /**
             * MSH: Look for supported attributes and add to hash map.
             * This is as tight as things can get :)
             * The data index is "just" where the keys and values are stored.
             */
            for(int i = 0; i < len; i++)
                attributes.put(data[i * 5 + 1], data[i * 5 + 4]);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return attributes;
    }

    public interface OnClickableListener {
        void onClick(String text, Editable output,Integer start,HashMap<String,String> attributes);
    }
}
