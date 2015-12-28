package com.yanyuanquan.android.yyqdyb.base;

import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class HttpManager {
    //apikey
    private static final String APIKEY ="772260bdd9468056455968df48cc80a0";

    private static final String MEITU_URL="http://apis.baidu.com/tngou/gallery/classify";
    private static final String MEITULIST_URL ="http://apis.baidu.com/tngou/gallery/list";
    //笑话
    private static final String JOKE_URL="http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
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
    //图文笑话
    private static final String JOKE_WITH_IMG_URL="http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_pic";
    public static void getJokeWithImage(String page, StringCallback callback){
        OkHttpUtils
                .get()
                .addHeader("apikey",APIKEY)
                .url(JOKE_WITH_IMG_URL)
                .addParams("page",page)
                .build()
                .execute(callback);
    }

    public static void downloadImage(String url ,Callback<byte[]> callback){
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(callback);

    }
    //同步网络请求 返回Response
    public static Response asyncGetData(String url){
        Response response =null;
        try {
           response = OkHttpUtils.get().url(url).build().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return response;
    }


}
