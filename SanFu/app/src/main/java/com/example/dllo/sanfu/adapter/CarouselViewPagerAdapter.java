package com.example.dllo.sanfu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.sanfu.bean.CarouselBean;
import com.example.dllo.sanfu.net.NetTool;

/**
 * Created by dllo on 16/7/6.
 */
public class CarouselViewPagerAdapter extends PagerAdapter {

    private CarouselBean carouselBean;
    private Context context;
    private NetTool netTool;

    public CarouselViewPagerAdapter(Context context) {
        this.context = context;
        netTool = new NetTool();
    }

    public void setCarouselBean(CarouselBean carouselBean) {
        this.carouselBean = carouselBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return carouselBean == null ? 0 : carouselBean.getData().getBanners().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        netTool.getImgAnalysis(carouselBean.getData().getBanners().get(position).getImage_url(),
                imageView);

        try {
            container.addView(imageView);
        } catch (IllegalStateException e) {
            container.removeView(imageView);
            container.addView(imageView);
        }


        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        if (container.getChildAt(position % carouselBean.getData().getBanners().size()) == object) {
            container.removeViewAt(position % carouselBean.getData().getBanners().size());
        }
    }
}
