package com.lt.app.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lt.app.R;

/**
 * Created by eo_cuong on 12/16/15.
 */
public class BaseHeader extends FrameLayout {


    ImageView imvHeader;

    public BaseHeader(Context context) {
        super(context);
        init();
    }

    public BaseHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.base_header, this, true);
        imvHeader = (ImageView) v.findViewById(R.id.imvHeader);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();

        BitmapFactory.Options dimensions = new BitmapFactory.Options();
        dimensions.inJustDecodeBounds = true;
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.header, dimensions);
        float heightBm = dimensions.outHeight;
        float widthBm = dimensions.outWidth;
        float ratio = (float)(widthBm / heightBm);


        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imvHeader.getLayoutParams();
        params.width = width;
        params.height = (int) (width / ratio);
        imvHeader.setLayoutParams(params);


    }
}
