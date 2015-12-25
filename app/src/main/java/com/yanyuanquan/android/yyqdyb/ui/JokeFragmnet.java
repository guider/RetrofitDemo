package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.adapter.JokeAdapter;
import com.yanyuanquan.android.yyqdyb.base.BaseFragment;
import com.yanyuanquan.android.yyqdyb.base.HttpManager;
import com.yanyuanquan.android.yyqdyb.entity.Joke;
import com.yanyuanquan.android.yyqdyb.widget.onLoadMoreLinstener;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class JokeFragmnet extends BaseFragment implements WaveSwipeRefreshLayout.OnRefreshListener, onLoadMoreLinstener {

    @Bind(R.id.joke_recyclerview)
    AutoRecyclerView jokeRecyclerview;
    @Bind(R.id.joke_waveswiperefreshlayout)
    WaveSwipeRefreshLayout jokeWaveswiperefreshlayout;
    JokeAdapter adapter;
    @Bind(R.id.linear_loading)
    LinearLayout linearLoading;
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void init() {
        adapter = new JokeAdapter(null, R.layout.item_main_joke);
        jokeRecyclerview.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        jokeRecyclerview.setLayoutManager(manager);
    }

    @Override
    protected void initView() {
        showJoke(1,false);
        jokeRecyclerview.setOnLoadMoreLinstener(this);
        jokeWaveswiperefreshlayout.setOnRefreshListener(this);

    }

    private void showJoke(int page,final boolean isLoadMore) {
        HttpManager.getJoke(String.valueOf(page), new StringCallback() {
            @Override
            public void onResponse(String response) {
                Joke joke = new Gson().fromJson(response, Joke.class);
                setData(joke,isLoadMore);
            }

            @Override
            public void onAfter() {
                if (jokeWaveswiperefreshlayout != null && jokeWaveswiperefreshlayout.isRefreshing())
                    jokeWaveswiperefreshlayout.setRefreshing(false);
                linearLoading.setVisibility(View.GONE);
            }
        });
    }

    private void setData(Joke joke,boolean isLoadMore) {
        if (joke.getShowapi_res_body().getContentlist()==null)
            return;
        adapter.appendDatas(joke.getShowapi_res_body().getContentlist());
        if (isLoadMore) {
            jokeRecyclerview.scrollToPosition(adapter.getItemCount() - joke.getShowapi_res_body().getContentlist().size());
            page++;
        }
    }


    @Override
    public void onRefresh() {
        showJoke(1,false);
    }

    @Override
    public void loadMore() {
        linearLoading.setVisibility(View.VISIBLE);
        showJoke(page,true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
