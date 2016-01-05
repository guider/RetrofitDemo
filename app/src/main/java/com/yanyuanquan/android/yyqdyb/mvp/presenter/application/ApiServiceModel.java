package com.yanyuanquan.android.yyqdyb.mvp.presenter.application;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.apiservice.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by apple on 16/1/5.
 */
@Module
public class ApiServiceModel {
    private static final String API = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClent(){
        OkHttpClient okHttpClient =new OkHttpClient();
        okHttpClient.setConnectTimeout(60*1000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(60*1000,TimeUnit.MILLISECONDS);
        return okHttpClient;
    }
    @Provides
    @Singleton
    Retrofit provideRestAdapter(Application application,OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder().client(new OkHttpClient()).baseUrl(API).
        addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit;
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }




}
