package com.example.afalse.guide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.afalse.bjnews.R;

import java.util.ArrayList;
import java.util.List;

public class GuidePagerAdapter extends PagerAdapter{
    public List<Integer> guideResIdList=new ArrayList<>();

    public GuidePagerAdapter() {
        //初始化引导页资源ID集合
        guideResIdList.add(R.drawable.guide_1);
        guideResIdList.add(R.drawable.guide_2);
        guideResIdList.add(R.drawable.guide_3);
    }

    @Override
    public int getCount() {
        return guideResIdList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Context context=container.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View pager=inflater.inflate(R.layout.pager_guide,container,false);
        ImageView guideImageView=pager.findViewById(R.id.guideImageView);
        Integer resId=guideResIdList.get(position);
        Log.i("hh","+1111");
        guideImageView.setImageResource(resId);
        container.addView(pager);
        return pager;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
