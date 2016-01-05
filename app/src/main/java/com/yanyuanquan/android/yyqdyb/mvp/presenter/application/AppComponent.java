package com.yanyuanquan.android.yyqdyb.mvp.presenter.application;

import android.app.Application;

import com.yanyuanquan.android.yyqdyb.mvp.presenter.apiservice.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by apple on 16/1/5.
 */
@Singleton
@Component(modules = {AppModel.class,ApiServiceModel.class})
public interface AppComponent  {
    Application getApplication();
    ApiService getService();
}
