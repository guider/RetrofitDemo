package com.yanyuanquan.android.yyqdyb.base;

import android.app.Activity;
import android.os.Bundle;

import com.yanyuanquan.android.yyqdyb.R;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        init();
        initView();
    }

    protected abstract int initLayout();
    protected abstract void init();
    protected abstract void initView();


}
