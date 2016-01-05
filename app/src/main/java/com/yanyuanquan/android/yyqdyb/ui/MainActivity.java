package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.adapter.MainJokeAdapter;
import com.yanyuanquan.android.yyqdyb.base.HttpManager;
import com.yanyuanquan.android.yyqdyb.entity.Joke;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.MainPresenter;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.iview.IMainView;
import com.zhy.http.okhttp.callback.StringCallback;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

public class MainActivity extends BaseCompatActivity implements WaveSwipeRefreshLayout.OnRefreshListener,IMainView{

    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.waveswipelayout)
    WaveSwipeRefreshLayout waveswipelayout;
    @Inject
    MainPresenter presenter;

    @Override
    protected void setupActivityComponent() {

//        DaggerMainActvityComponent.builder();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
//        init();
//        initView();
    }

    @Override
    public void showLog(String msg) {
        Log.i("zjw", msg);
    }

    private void init() {
        waveswipelayout.setOnRefreshListener(this);
    }

    private void initView() {
        HttpManager.getJoke(String.valueOf(1), new StringCallback() {
            @Override
            public void onResponse(String response) {
                Joke joke = new Gson().fromJson(response, Joke.class);
                setData(joke);
            }

            @Override
            public void onAfter() {
                super.onAfter();
                if (waveswipelayout != null || waveswipelayout.isRefreshing()) {
                    waveswipelayout.setRefreshing(false);
                }
            }
        });


    }


    private void setData(Joke joke) {
        recyclerview.setAdapter(new MainJokeAdapter(joke.getShowapi_res_body().getContentlist(), R.layout.item_main_joke));
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(manager);
    }


    @Override
    public void onRefresh() {
        initView();
    }
}
