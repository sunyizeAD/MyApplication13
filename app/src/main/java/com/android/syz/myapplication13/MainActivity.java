package com.android.syz.myapplication13;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyLinearLayout ll_progress = (MyLinearLayout) findViewById(R.id.ll_progress);
        ObjectAnimator animator =ObjectAnimator.ofFloat(ll_progress,"progress",0,100);
        animator.setDuration(2000);
        L.init("sunyiz",true);
//        animator.setInterpolator(new AccelerateDecelerateInterpolator());//先加速后减速
//        animator.setInterpolator(new AccelerateInterpolator());//持续加速
//        animator.setInterpolator(new LinearInterpolator());//匀速
//        animator.setInterpolator(new DecelerateInterpolator());//持续减速到0
//        animator.setInterpolator(new AnticipateInterpolator());//先回拉，后进行正常轨迹，抛物姿势
//        animator.setInterpolator(new OvershootInterpolator());//超出，回弹
//        animator.setInterpolator(new AnticipateOvershootInterpolator());//回拉，超出，回弹结合
        animator.setInterpolator(new BounceInterpolator());//目标出弹来弹去
        animator.start();

        ll_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,Page2.class));
//                a();
                L.e("哈哈哈哈，你好啊",view);
            }
        });

    }

    private  void a(){
        b();
    }

    private void b() {
        StringBuffer buffer =new StringBuffer();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i =0;i<stackTrace.length;i++)
        {
            buffer.append("\tat ");
            buffer.append(stackTrace[i].toString());
            buffer.append("\n");

        }
        Log.e(TAG,buffer.toString());
    }
}
