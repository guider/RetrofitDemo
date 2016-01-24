package com.yanyuanquan.android.yyqdyb.mvp.presenter.apiservice;

import com.yanyuanquan.android.yyqdyb.entity.GitHub;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by apple on 16/1/4.
 */
public interface ApiService {
//    @Headers("772260bdd9468056455968df48cc80a0")
    @GET("contributors?%0Apage=2")
    Observable<List<GitHub>> getJokeImg();

}
