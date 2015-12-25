package com.yanyuanquan.android.yyqdyb.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initView();
    }
    protected abstract void init();
    protected abstract void initView();


}
