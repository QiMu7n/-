package com.example.afalse.splash;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.afalse.base.BaseActivity;
import com.example.afalse.bjnews.R;
import com.example.afalse.guide.GuideActivity;

public class SplashActivity extends BaseActivity {

    private ImageView animationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        startAnimatorSet(animationLayout);
    }

    private void startAnimatorSet(ImageView animationLayout) {
        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(animationLayout,"scaleX",0,1);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(animationLayout,"scaleY",0,1);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(animationLayout,"rotation",0,1080);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(animationLayout,"alpha",0,1f);
        animatorSet.setDuration(3000);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                //动画结束，启动引导页
                startActivity(new Intent(context, GuideActivity.class));
                SplashActivity.this.finish();
            }
        });
        animatorSet.playTogether(scaleX,scaleY,rotation,alpha);
        animatorSet.start();
    }

    private void initView() {
        animationLayout = (ImageView) findViewById(R.id.animationLayout);
    }
}
