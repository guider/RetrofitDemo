package com.yanyuanquan.android.yyqdyb.mvp.presenter;

import com.yanyuanquan.android.yyqdyb.entity.JokeWithImg;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.apiservice.ApiService;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.iview.IMainView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by apple on 16/1/4.
 */
public class MainPresenter implements Presenter {
    private ApiService apiService;
    private IMainView mView;

    public MainPresenter(ApiService apiService, IMainView mView) {
        this.apiService = apiService;
        this.mView = mView;
    }

    @Override
    public void onCreate() {
        apiService.getJokeImg(2015).observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<JokeWithImg, JokeWithImg>() {
                    @Override
                    public JokeWithImg call(JokeWithImg jokeWithImg) {
                        return jokeWithImg;
                    }
                })
                .subscribe(new Action1<JokeWithImg>() {
                    @Override
                    public void call(JokeWithImg jokeWithImg) {
                        mView.showLog(jokeWithImg.toString());
                    }
                });

    }

    @Override
    public void onDestory() {

    }
}
