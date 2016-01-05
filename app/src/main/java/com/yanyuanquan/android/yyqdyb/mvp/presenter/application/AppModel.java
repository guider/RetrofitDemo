package com.yanyuanquan.android.yyqdyb.mvp.presenter.application;

import android.app.Application;

import com.yanyuanquan.android.yyqdyb.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by apple on 16/1/5.
 */
@Module
public class AppModel {
    private Application application;

    public AppModel(Application application) {
        this.application = application;
    }
    @Provides
    @Singleton
    public Application providerApplication(){
        return application;
    }
}
