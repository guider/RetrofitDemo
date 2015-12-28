package com.yanyuanquan.android.yyqdyb.photoview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by apple on 15/12/28.
 */
public class ActivityImagePager extends BaseActivity {
    static final String IMAGEURLS="imgurls";
    static final String CURRENT_IMAGE="currentimage";
    @Bind(R.id.back)
    TextView back;
    @Bind(R.id.photonum)
    TextView photonum;
    @Bind(R.id.viewpager)
    HackViewPager viewpager;
    private List<String> imgurls;
    private int imgsize;
    private int currentImage;
    PhotoPagerAdapter adapter;

    @Override
    protected int initLayout() {
        return R.layout.activity_photopager;
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
        if (getIntent()==null){
            finish();
            return;
        }
        photonum.setText(String.valueOf(currentImage+"/"+imgsize));
        imgurls = getIntent().getStringArrayListExtra(IMAGEURLS);
        imgsize = imgurls==null?0:imgurls.size();
        currentImage = getIntent().getIntExtra(CURRENT_IMAGE,1);
        photonum.setText(String.valueOf(currentImage+"/"+imgsize));
    }

    @Override
    protected void initView() {
        adapter = new PhotoPagerAdapter();
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(currentImage);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                photonum.setText(String.valueOf(position+"/"+imgsize));
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    public static void  show(ArrayList<String> imgurls,int currentImage, Context context){
        Intent intent = new Intent(context,ActivityImagePager.class);
        intent.putStringArrayListExtra(IMAGEURLS,imgurls);
        intent.putExtra(CURRENT_IMAGE,currentImage);
        context.startActivity(intent);
    }


    class PhotoPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return imgurls==null?null:imgurls.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view ==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(getApplication());
            Picasso.with(getApplication()).load(imgurls.get(position)).into(photoView);
            container.addView(photoView);
            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
