package com.yanyuanquan.android.yyqdyb.mvp.presenter.application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.apiservice.ApiService;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by apple on 16/1/5.
 */
@Module
public class ApiServiceModel {
    //apikey
    private static final String APIKEY ="772260bdd9468056455968df48cc80a0";
    private static final String API = "https://api.github.com/repositories/892275/";
    final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();


//    @Provides
//    @Singleton
//    OkHttpClient provideOkHttpClent(){
//        OkHttpClient okHttpClient =new OkHttpClient();
//        okHttpClient.setConnectTimeout(60*1000, TimeUnit.MILLISECONDS);
//        okHttpClient.setReadTimeout(60*1000,TimeUnit.MILLISECONDS);
//        return okHttpClient;
//    }
    @Provides
    @Singleton
    Retrofit provideRestRetrofit(){
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response;
            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .client(client).baseUrl(API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }


//    //注意这里的Gson的构建方式为GsonBuilder,区别于test1中的Gson gson = new Gson();
//    Gson gson = new GsonBuilder()
//            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
//            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
//            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
//            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
//            .setPrettyPrinting() //对json结果格式化.
//            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
//            //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
//            //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
//            .create();

}
