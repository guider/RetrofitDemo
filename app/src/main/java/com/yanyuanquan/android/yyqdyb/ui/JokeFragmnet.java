package com.yanyuanquan.android.yyqdyb.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.yanyuanquan.android.yyqdyb.R;
import com.yanyuanquan.android.yyqdyb.base.BaseFragment;
import com.yanyuanquan.android.yyqdyb.base.JokeFragmentController;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class JokeFragmnet extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.radio_group)
    RadioGroup radioGroup;
    private JokeFragmentController controller;


    @Override
    protected int initLayout() {
        return R.layout.fragment_joke;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.joke_with_img:
                controller.showFragment(0);
                break;
            default:
                controller.showFragment(1);
                break;
        }
    }

    @Override
    protected void init() {
        radioGroup.setOnCheckedChangeListener(this);
        controller = new JokeFragmentController(getActivity(), R.id.joke_framelayout);
        controller.showFragment(0);

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
