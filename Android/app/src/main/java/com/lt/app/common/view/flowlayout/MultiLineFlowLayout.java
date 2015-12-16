package com.lt.app.common.view.flowlayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import com.lt.app.R;
import com.lt.app.common.util.DimenUtils;

/**
 * Created by khacpham on 12/16/15.
 */
@TargetApi(16)
public class MultiLineFlowLayout extends FlowLayout {
    private int itemMargin = 20;
    private int dividerColor = Color.BLACK;
    private int dividerHeight = 2;

    private Rect mRect;
    private Paint mPaint;

    public MultiLineFlowLayout(Context context) {
        super(context);
        init(null);
    }

    public MultiLineFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MultiLineFlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        itemMargin = DimenUtils.dpToPx(getContext(), itemMargin);

        if(attrs != null){
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MultiLineFlowLayout, 0, 0);
            itemMargin = a.getDimensionPixelSize(R.styleable.MultiLineFlowLayout_itemMargin, itemMargin);
            dividerColor = a.getColor(R.styleable.MultiLineFlowLayout_dividerColor, dividerColor);
            dividerHeight = a.getDimensionPixelSize(R.styleable.MultiLineFlowLayout_dividerHeight, dividerHeight);
            a.recycle();
        }

        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(dividerColor);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int h = resolveSize(getMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, h);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        int count = getLineCount();
        Rect r = mRect;
        Paint paint = mPaint;

        for (int i = 0; i <= count; i++) {
            getLineBounds(i, r);
            canvas.drawRect(r, paint);
        }

        super.dispatchDraw(canvas);
    }

    public int getLineCount(){
        return 3;
    }

    public int getLineBounds(int index, Rect r){
        int itemHeight = DimenUtils.dpToPx(getContext(),72);
        int baseLine = itemHeight*(index+1)- itemMargin;
        r.left = 0;
        r.right = getMeasuredWidth();
        r.top = baseLine-3;
        r.bottom = baseLine+dividerHeight-3;
        return baseLine;
    }
}
