package com.android.syz.myapplication13;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.BoringLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by syz on 2017/9/6 .
 */

public class MyViewDemo1 extends View {

    private Paint paint;

    public MyViewDemo1(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(150);
        paint.setStrokeMiter(2);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
//        paint.setColorFilter(new LightingColorFilter(0X00FFFF,0Xff0000));


    }

    public MyViewDemo1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyViewDemo1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Xfermode  xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);
//        canvas.drawRect(0,0,200,200,paint);
//        paint.setXfermode(xfermode);
//        Matrix matrix = new Matrix();
//        float[] src = {50,0,100,0,50,100,100,100};
//        float[] d = {60,20,60,50,60,110,120,50};
//        matrix.setPolyToPoly(src,0,d,0,4);
//        canvas.drawCircle(200,200,100,paint);
//        Path path = new Path();
//        path.moveTo(100,100);
//        path.lineTo(200,1000);
//        path.lineTo(500,500);
//        path.close();
//        canvas.drawPath(path,paint);
        canvas.save();
//        canvas.setMatrix(matrix);
//        canvas.translate(100,100);
//        canvas.clipRect(50,50,200,200);
        canvas.rotate(30,100,100);//旋转
//        canvas.scale(2,3,100,100);//缩放
//        canvas.skew(0,0.5f);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();
//        paint.setXfermode(null);
//        canvas.restoreToCount(save);

    }
}
