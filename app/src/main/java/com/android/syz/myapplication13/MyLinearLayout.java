package com.android.syz.myapplication13;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by syz on 2017/9/18 .
 */

public class MyLinearLayout extends LinearLayout {

    private Paint paint;

    public MyLinearLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private float progress = 0;

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
                invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawCircle(100,100,30,paint);
        canvas.drawCircle(150,150,10,paint);
        canvas.drawCircle(10,50,20,paint);
        canvas.drawArc(100,100,500,500,-180,3.6f*progress,false,paint);
    }

}
