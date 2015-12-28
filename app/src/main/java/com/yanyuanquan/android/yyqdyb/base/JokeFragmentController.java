package com.yanyuanquan.android.yyqdyb.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.yanyuanquan.android.yyqdyb.ui.JokeImageFragmnet;
import com.yanyuanquan.android.yyqdyb.ui.JokeTextFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class JokeFragmentController {
    private static JokeFragmentController controller;
    private FragmentManager fm;
    private List<Fragment> fs;
    public static JokeFragmentController getInstance(FragmentActivity activity, int containId){
        if (controller ==null)
            controller =new JokeFragmentController(activity,containId);
        return controller;
    }
    public JokeFragmentController(FragmentActivity activity, int containId) {
        fm = activity.getSupportFragmentManager();
        init(containId);
    }

    private void init(int containId) {
        fs = new ArrayList<Fragment>();
        fs.add(new JokeImageFragmnet());
        fs.add(new JokeTextFragment());
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment f:fs){
            ft.add(containId,f);
        }
        ft.commit();
    }
    public void showFragment(int position){
        hideFragment();
        FragmentTransaction ft =fm.beginTransaction();
        ft.show(fs.get(position));
        ft.commit();
    }

    private void hideFragment() {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment f:fs){
            if (f!=null)
                ft.hide(f);
        }
        ft.commit();
    }
    public Fragment getFragment(int position){
        return fs.get(position);
    }

}
