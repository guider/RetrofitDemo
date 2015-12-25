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
    private static final String MEITU_URL="http://apis.baidu.com/tngou/gallery/classify";
    private static final String MEITULIST_URL ="http://apis.baidu.com/tngou/gallery/list";
    public static void getJoke(String page, StringCallback callback){
            OkHttpUtils
                    .get()
                    .addHeader("apikey",APIKEY)
                    .url(JOKE_URL)
                    .addParams("page",page)
                    .build()
                    .execute(callback);
    }


    public static void getMeiTu(StringCallback callback){
        OkHttpUtils
                .get()
                .addHeader("apikey",APIKEY)
                .url(MEITU_URL)
                .build()
                .execute(callback);
    }


    public static void getMeiTuList(int id, int page,StringCallback callback) {
        OkHttpUtils.get()
                .addHeader("apikey",APIKEY)
                .url(MEITULIST_URL)
                .addParams("id",String.valueOf(id))
                .addParams("page",String.valueOf(page))
                .addParams("rows",String.valueOf(20))
                .build()
                .execute(callback);
    }
}
