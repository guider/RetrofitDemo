package com.yanyuanquan.android.yyqdyb.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.yanyuanquan.android.yyqdyb.ui.GirlFragment;
import com.yanyuanquan.android.yyqdyb.ui.JokeFragmnet;
import com.yanyuanquan.android.yyqdyb.ui.NewsFragment;
import com.yanyuanquan.android.yyqdyb.ui.NoteFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class FragmentController {
    private static FragmentController controller;
    private FragmentManager fm;
    private List<Fragment> fs;
    public static FragmentController getInstance(FragmentActivity activity,int containId){
        if (controller ==null)
            controller =new FragmentController(activity,containId);
        return controller;
    }
    public FragmentController(FragmentActivity activity,int containId) {
        fm = activity.getSupportFragmentManager();
        init(containId);
    }

    private void init(int containId) {
        fs = new ArrayList<Fragment>();
        fs.add(new JokeFragmnet());
        fs.add(new GirlFragment());
        fs.add(new NewsFragment());
        fs.add(new NoteFragment());
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
