package com.yanyuanquan.android.yyqdyb;

import android.app.Application;
import android.content.Context;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init() {



    }
}
