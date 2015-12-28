package com.yanyuanquan.android.yyqdyb.photoview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by apple on 15/12/28.
 */
public class HackViewPager extends ViewPager{
    public HackViewPager(Context context) {
        super(context);
    }

    public HackViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {

            return super.onInterceptTouchEvent(ev);
        }catch (Exception e) {
            return false;
        }
    }
}
