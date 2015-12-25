package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.adapter.MainJokeAdapter;
import com.yanyuanquan.android.yyqdyb.base.HttpManager;
import com.yanyuanquan.android.yyqdyb.entity.Joke;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

public class TestActivity extends AppCompatActivity implements WaveSwipeRefreshLayout.OnRefreshListener{

    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.waveswipelayout)
    WaveSwipeRefreshLayout waveswipelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        init();
        initView();

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
                if (waveswipelayout!=null||waveswipelayout.isRefreshing()){
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        initView();
    }
}
