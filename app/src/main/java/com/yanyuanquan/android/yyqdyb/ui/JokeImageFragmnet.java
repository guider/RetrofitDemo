package com.yanyuanquan.android.yyqdyb.ui;

import android.util.Log;

import com.google.gson.Gson;
import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.adapter.JokeWithImageAdapter;
import com.yanyuanquan.android.yyqdyb.base.CompatListFragment;
import com.yanyuanquan.android.yyqdyb.base.HttpManager;
import com.yanyuanquan.android.yyqdyb.entity.JokeWithImg;
import com.yanyuanquan.android.yyqdyb.photoview.ActivityImagePager;
import com.yanyuanquan.android.yyqdyb.widget.CustomToast;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnItemClick;
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public class JokeImageFragmnet extends CompatListFragment implements WaveSwipeRefreshLayout.OnRefreshListener{

    private JokeWithImg jokeWithImg;
    JokeWithImageAdapter adapter;
    @Override
    protected void init() {
        waveswipelayout.setOnRefreshListener(this);
    }

    @Override
    protected void initView() {
        HttpManager.getJokeWithImage(String.valueOf(1), new StringCallback() {
            @Override
            public void onResponse(String response) {
                jokeWithImg = new Gson().fromJson(response,JokeWithImg.class);
                setData(jokeWithImg.getShowapi_res_body().getContentlist());
            }
        });
    }

    public void setData(List<JokeWithImg.ShowapiResBodyEntity.ContentlistEntity> data) {
        if (data==null)
            return;
        if (adapter ==null) {
            adapter = new JokeWithImageAdapter(data,R.layout.item_joke_gif,context);
            listview.setAdapter(adapter);
        }else {
            adapter.setData(data);
            waveswipelayout.setRefreshing(false);
        }

    }
    @OnItemClick(R.id.listview)
    void onItemClick(int position){

        ArrayList<String> imgurls = new ArrayList<String>();
        for (JokeWithImg.ShowapiResBodyEntity.ContentlistEntity list : jokeWithImg.getShowapi_res_body().getContentlist()){
            imgurls.add(String.valueOf(list.getImg()));
        }
        ActivityImagePager.show(imgurls,position,context);

    }

    @Override
    public void onRefresh() {
       initView();
    }
}
