package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Request;
import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.BaseFragment;
import com.yanyuanquan.android.yyqdyb.base.HttpManager;
import com.yanyuanquan.android.yyqdyb.entity.MeiTuClassify;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class MeiTuFragment extends BaseFragment {

    @Bind(R.id.meitu_tablayout)
    TabLayout meituTablayout;
    @Bind(R.id.meitu_viewpager)
    ViewPager meituViewpager;
    List<Fragment> fs;
    private List<MeiTuClassify> meiTuClassifies;

    @Override
    protected int initLayout() {
        return R.layout.fragment_meitu;
    }

    @Override
    protected void init() {
        fs = new ArrayList<Fragment>();
        meiTuClassifies = new ArrayList<MeiTuClassify>();
    }

    @Override
    protected void initView() {
        initData();
    }

    private void initData() {
        HttpManager.getMeiTu(new StringCallback() {
            @Override
            public void onResponse(String response) {

                try {
                    meiTuClassifies = JSON.parseArray(new JSONObject(response).optString("tngou"), MeiTuClassify.class);
                    setData(meiTuClassifies);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Request request, Exception e) {
            }
        });
    }


    public void setData(List<MeiTuClassify> data) {
        if (data == null)
            return;
        for (MeiTuClassify d : data) {
            Fragment f = new MeituItemFragment();
            Bundle b = new Bundle();
            b.putInt("id", d.getId());
            f.setArguments(b);
            fs.add(f);
        }
        meituViewpager.setAdapter(new MeituPagerAdapter(getFragmentManager()));
        meituTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        meituTablayout.setupWithViewPager(meituViewpager);
    }

    class MeituPagerAdapter extends FragmentPagerAdapter {
        public MeituPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fs.get(position);
        }

        @Override
        public int getCount() {
            return meiTuClassifies.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return meiTuClassifies.get(position).getTitle();
        }
    }
}
