package com.yanyuanquan.android.yyqdyb.mvp.presenter;

import android.util.Log;

import com.yanyuanquan.android.yyqdyb.entity.GitHub;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.apiservice.ApiService;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.iview.IMainView;

import java.util.List;

import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
        apiService.getJokeImg().subscribeOn(Schedulers.io())
               .subscribe(new Action1<List<GitHub>>() {
                   @Override
                   public void call(List<GitHub> gitHubs) {
                       Log.i("zjw",gitHubs.toString());
                   }
               }, new Action1<Throwable>() {


                   @Override
                   public void call(Throwable throwable) {
                       Log.i("zjw", throwable.toString());
                   }
               });
    }
    @Override
    public void onDestory() {

    }
}
