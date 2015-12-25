package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;

/**
 * @Created by apple on 15/12/25.
 * @description:
 * @projectName:YYQDYB
 */
public class BaseListFragment extends ListFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initView();
    }
    private void init() {
    }

    private void initView() {
    }
}
