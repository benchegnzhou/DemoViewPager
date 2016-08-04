package com.itcast.zbc.demoviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int[] imgRes = {R.mipmap.dog1, R.mipmap.dog2, R.mipmap.dog3};
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //设置Page间间距
        mViewPager.setPageMargin(20);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageTransformer(true,new AlphaPageTransformer());

        mViewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(imgRes[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                container.addView(imageView);

                return imageView;
            }

            @Override
            public int getCount() {
                return imgRes.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }



            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
               container.removeView((View) object);
            }
        });


    }


}
