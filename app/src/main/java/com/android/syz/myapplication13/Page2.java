package com.android.syz.myapplication13;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by syz on 2017/9/21 .
 */

public class Page2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
       ImageView imageView = findViewById(R.id.imageView);
        DisplayMetrics metrics =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;
        try {
            InputStream open = getAssets().open("image.JPG");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds =true;
            BitmapFactory.decodeStream(open, null, options);
            int height = options.outHeight;
            int width = options.outWidth;

            BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder.newInstance(open, false);
            BitmapFactory.Options options1 = new BitmapFactory.Options();
            options1.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap bitmap = bitmapRegionDecoder.decodeRegion(new Rect(width / 2 - widthPixels/2, height / 2 - heightPixels/2, width / 2 + widthPixels/2, height / 2 + heightPixels/2), options1);
            imageView.setImageBitmap(bitmap);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
