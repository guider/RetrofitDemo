package com.yanyuanquan.android.yyqdyb.ui;

import android.app.Activity;
import android.os.Bundle;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.yanyuanquan.android.yyqdyb.R;

import java.io.File;
import java.io.IOException;

/**
 * @Created by apple on 16/1/6.
 * @description:
 * @projectName:YYQDYB
 */
public class TestActivity extends Activity {

    private OkHttpClient client;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        client = new OkHttpClient();
        File sdcache = getExternalCacheDir();
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        client.setCache(new Cache(sdcache.getAbsoluteFile(), cacheSize));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    execute();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage().toString());
                }
            }
        }).start();
    }

    public void execute() throws Exception {


        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        Response response1 = client.newCall(request).execute();
        if (!response1.isSuccessful()) throw new IOException("Unexpected code " + response1);

        String response1Body = response1.body().string();
        System.out.println("Response 1 response:          " + response1);
        System.out.println("Response 1 cache response:    " + response1.cacheResponse());
        System.out.println("Response 1 network response:  " + response1.networkResponse());

        request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
//        Response response2 = client.newCall(request).execute();
//        if (!response2.isSuccessful()) throw new IOException("Unexpected code " + response2);
//
//        String response2Body = response2.body().string();
//        System.out.println("Response 2 response:          " + response2);
//        System.out.println("Response 2 cache response:    " + response2.cacheResponse());
//        System.out.println("Response 2 network response:  " + response2.networkResponse());
//
//        System.out.println("Response 2 equals Response 1? " + response1Body.equals(response2Body));

    }
}
