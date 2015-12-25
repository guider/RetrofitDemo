package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.BaseAdapter;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public abstract class BaseListFragment<T> extends ListFragment {
    protected BaseAdapter adapter;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

    }
    protected abstract void init();

}
