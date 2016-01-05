package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by apple on 16/1/5.
 */
public abstract class BaseCompatActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setupActivityComponent();

    }

    protected abstract void setupActivityComponent();
}
