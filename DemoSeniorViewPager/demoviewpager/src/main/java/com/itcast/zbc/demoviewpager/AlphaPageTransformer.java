package com.itcast.zbc.demoviewpager;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Zbc on 2016/8/4.
 */
public class AlphaPageTransformer implements ViewPager.PageTransformer {
    float mMinAlpha = 0.5f;
    private String TAG = AlphaPageTransformer.class.getSimpleName();
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;
    /**
     * Apply a property transformation to the given page.
     *
     * @param page     Apply the transformation to this page
     * @param position Position of page relative to the current front-and-center
     *                 position of the pager. 0 is front and center. 1 is one full
     */
    @Override
    public void transformPage(View page, float position) {
        Log.e(TAG, "transformPage:position " + position);
        if (position < -1) {           //(  ,-1)
            page.setAlpha(mMinAlpha);
            page.setRotation(mMaxRotate * -1);
            page.setPivotX(page.getWidth());
            page.setPivotY(page.getHeight());

        } else if (position < 1) {
            if (position > 0) {   //[0 , -1]
                float factor = mMinAlpha + (1 - mMinAlpha) * (1 + position);

                page.setAlpha(factor);
                page.setPivotX(page.getWidth() * (0.5f + 0.5f * (-position)));
                page.setPivotY(page.getHeight());
                page.setRotation(mMaxRotate * position);

            } else {  //[1，0]
                float factor = mMinAlpha + (1 - mMinAlpha) * (1 - position);
                page.setAlpha(factor);
                page.setPivotX(page.getWidth() * 0.5f * (1 - position));
                page.setPivotY(page.getHeight());
                page.setRotation(mMaxRotate * position);


            }
        } else {    //(1,  )
            page.setAlpha(mMinAlpha);
            // This page is way off-screen to the right.
            page.setRotation(mMaxRotate);
            page.setPivotX(page.getWidth() * 0);
            page.setPivotY(page.getHeight());

        }

    }

}
