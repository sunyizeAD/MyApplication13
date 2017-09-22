package com.android.syz.myapplication13;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by syz on 2017/9/21 .
 */

public class MyBitImageView extends android.support.v7.widget.AppCompatImageView {
    public static BitmapFactory.Options options = new BitmapFactory.Options();
    private BitmapRegionDecoder mDecoder ;
    static {
        options.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    public void setInputStream(InputStream in){
                try {
            mDecoder= BitmapRegionDecoder.newInstance(in,false);
                    BitmapFactory.Options options1=new BitmapFactory.Options();
                    options1.inJustDecodeBounds =true;
                    BitmapFactory.decodeStream(in,null,options1);
                    int outHeight = options1.outHeight;
                    int outWidth = options1.outWidth;
                } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public MyBitImageView(Context context) {
        super(context);
        init();
    }

    private void init() {

    }

    public MyBitImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyBitImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }
}
