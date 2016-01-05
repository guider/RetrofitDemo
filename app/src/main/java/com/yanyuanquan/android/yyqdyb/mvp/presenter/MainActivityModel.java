package com.yanyuanquan.android.yyqdyb.mvp.presenter;

import com.yanyuanquan.android.yyqdyb.mvp.presenter.apiservice.ApiService;
import com.yanyuanquan.android.yyqdyb.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by apple on 16/1/5.
 */
@Module
public class MainActivityModel {
    private MainActivity mainActivity;

    public MainActivityModel(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    @Provides
    @ActivityScope
    MainActivity provideMainActivity(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter (ApiService service){
        return new MainPresenter(service,mainActivity);
    }


}
