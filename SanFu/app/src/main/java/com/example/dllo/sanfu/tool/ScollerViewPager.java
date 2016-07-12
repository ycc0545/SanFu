package com.example.dllo.sanfu.tool;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by dllo on 16/7/6.
 */
public class ScollerViewPager extends Scroller {
    private int mDuration = 5000;//设置移动速度

    public int getmDuration() {
        return mDuration;
    }

    public void setmDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public ScollerViewPager(Context context) {
        super(context);
    }

    public ScollerViewPager(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public ScollerViewPager(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);

    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}
