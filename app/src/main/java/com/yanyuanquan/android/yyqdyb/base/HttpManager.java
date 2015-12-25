package com.yanyuanquan.android.yyqdyb.base;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class HttpManager {
    private static final String APIKEY ="772260bdd9468056455968df48cc80a0";
    private static final String JOKE_URL="http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    private static final String MEINV_URL="http://apis.baidu.com/txapi/mvtp/meinv";

    public static void getJoke(String page, StringCallback callback){
            OkHttpUtils
                    .get()
                    .addHeader("apikey",APIKEY)
                    .url(JOKE_URL)
                    .addParams("page",page)
                    .build()
                    .execute(callback);
    }


    public static void getMeiNv(String page, StringCallback callback){
        OkHttpUtils
                .get()
                .addHeader("apikey",APIKEY)
                .url(MEINV_URL)
                .addParams("num",String.valueOf(15))
                .build()
                .execute(callback);
    }






}
