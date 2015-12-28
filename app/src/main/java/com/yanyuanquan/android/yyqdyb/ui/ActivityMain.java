package com.yanyuanquan.android.yyqdyb.ui;

import android.widget.RadioGroup;

import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.BaseFragmentActivity;
import com.yanyuanquan.android.yyqdyb.base.FragmentController;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class ActivityMain extends BaseFragmentActivity implements RadioGroup.OnCheckedChangeListener {
    FragmentController controller;
    @Bind(R.id.main_radiogroup)
    RadioGroup mainRadiogroup;

    @Override
    protected void init() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainRadiogroup.setOnCheckedChangeListener(this);
        controller = new FragmentController(this, R.id.framelayout);
    }

    @Override
    protected void initView() {
        controller.showFragment(0);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_joke_but:
                controller.showFragment(0);
                break;
            case R.id.main_girl_but:
                controller.showFragment(1);
                break;
            case R.id.main_news_but:
                controller.showFragment(2);
                break;
            case R.id.main_note_but:
                controller.showFragment(3);
                break;

        }

    }


}
