package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.BaseFragment;
import com.yanyuanquan.android.yyqdyb.base.JokeFragmentController;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class JokeFragmnet extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.radio_group)
    RadioGroup radioGroup;
    private JokeFragmentController controller;


    @Override
    protected int initLayout() {
        return R.layout.fragment_joke;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.joke_with_img:
                controller.showFragment(0);
                break;
            default:
                controller.showFragment(1);
                break;
        }
    }

    @Override
    protected void init() {
        radioGroup.setOnCheckedChangeListener(this);
        controller = new JokeFragmentController(getActivity(), R.id.joke_framelayout);
        controller.showFragment(0);

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

//        adapter = new JokeAdapter(null, R.layout.item_main_joke);
//        jokeRecyclerview.setAdapter(adapter);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//        jokeRecyclerview.setLayoutManager(manager);
//    }
//
//    @Override
//    protected void initView() {
//        showJoke(1,false);
//        jokeRecyclerview.setOnLoadMoreLinstener(this);
//        jokeWaveswiperefreshlayout.setOnRefreshListener(this);
//
//    }
//
//    private void showJoke(int page,final boolean isLoadMore) {
//        HttpManager.getJoke(String.valueOf(page), new StringCallback() {
//            @Override
//            public void onResponse(String response) {
//                Joke joke = new Gson().fromJson(response, Joke.class);
//                setData(joke,isLoadMore);
//            }
//
//            @Override
//            public void onAfter() {
//                if (jokeWaveswiperefreshlayout != null && jokeWaveswiperefreshlayout.isRefreshing())
//                    jokeWaveswiperefreshlayout.setRefreshing(false);
//                linearLoading.setVisibility(View.GONE);
//            }
//        });
//    }
//
//    private void setData(Joke joke,boolean isLoadMore) {
//        if (joke.getShowapi_res_body().getContentlist()==null)
//            return;
//        adapter.appendDatas(joke.getShowapi_res_body().getContentlist());
//        if (isLoadMore) {
//            jokeRecyclerview.scrollToPosition(adapter.getItemCount() - joke.getShowapi_res_body().getContentlist().size());
//            page++;
//        }
//    }
//
//
//    @Override
//    public void onRefresh() {
//        showJoke(1,false);
//    }
//
//    @Override
//    public void loadMore() {
//        linearLoading.setVisibility(View.VISIBLE);
//        showJoke(page,true);
//    }


}
