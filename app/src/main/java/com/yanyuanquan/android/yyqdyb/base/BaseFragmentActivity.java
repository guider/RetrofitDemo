package com.yanyuanquan.android.yyqdyb.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public abstract class BaseFragmentActivity extends FragmentActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initView();
    }
    protected abstract void init();
    protected abstract void initView();
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

    }

}
