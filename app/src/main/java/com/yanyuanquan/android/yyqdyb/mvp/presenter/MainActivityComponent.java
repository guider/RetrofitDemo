package com.yanyuanquan.android.yyqdyb.mvp.presenter;

import com.yanyuanquan.android.yyqdyb.mvp.presenter.application.AppComponent;
import com.yanyuanquan.android.yyqdyb.ui.MainActivity;

import dagger.Component;

/**
 * Created by apple on 16/1/5.
 */
@ActivityScope
@Component(modules = MainActivityModel.class,dependencies = AppComponent.class)

public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);

}
