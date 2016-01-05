package com.yanyuanquan.android.yyqdyb.mvp.presenter.apiservice;

import com.yanyuanquan.android.yyqdyb.entity.JokeWithImg;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by apple on 16/1/4.
 */
public interface ApiService {
    @GET("day/{year}")
    Observable<JokeWithImg> getJokeImg(@Path("year") int year);

}
