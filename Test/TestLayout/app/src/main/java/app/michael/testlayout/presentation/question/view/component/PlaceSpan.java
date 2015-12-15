package app.michael.testlayout.presentation.question.view.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/**
 * Created by michael on 12/3/15.
 */
public class PlaceSpan extends ReplacementSpan {
    private Paint paint;
    private int place_width=0;

    public PlaceSpan() {
        paint = new Paint();

    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        place_width= (int)paint.measureText(text,start,end);
        return  place_width;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        this.paint.setColor(0xffff0000);
        canvas.drawLine(x,y,x+place_width,y,this.paint);
    }
}
