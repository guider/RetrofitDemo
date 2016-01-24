package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yanyuanquan.android.yyqdyb.App;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.application.AppComponent;

/**
 * Created by apple on 16/1/5.
 */
public abstract class BaseCompatActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.getContext(this).getAppComponent());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);
}
