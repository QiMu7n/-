package com.example.afalse.guide;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.afalse.base.BaseActivity;
import com.example.afalse.bjnews.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {

    private ViewPager guideViewPager;
    private View redDotView;
    private ImageView [] image;
    private GuidePagerAdapter adapter;
    private int [] inid={R.id.iv1,R.id.iv2,R.id.iv3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        guideViewPager.setAdapter(new GuidePagerAdapter());
        //监听ViewPager滑动事件
        guideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                redDotView.setTranslationX(i1);
            }

            @Override
            public void onPageSelected(int position) {
                for(int j=0;j<adapter.guideResIdList.size();j++){
                    if(position==j){
                        image[j].setImageResource(R.drawable.shape_dot_red);
                    }else{
                        image[j].setImageResource(R.drawable.shape_dot_gray);
                    }
                    if(position !=adapter.guideResIdList.get(0)){
                        redDotView.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        image=new ImageView[adapter.guideResIdList.size()];
        for (int i=0;i<adapter.guideResIdList.size();i++){
            image[i]=findViewById(inid[i]);
        }
    }

    private void initView() {
        guideViewPager = (ViewPager) findViewById(R.id.guideViewPager);
        redDotView = (View) findViewById(R.id.redDotView);
        adapter=new GuidePagerAdapter();
    }
}
