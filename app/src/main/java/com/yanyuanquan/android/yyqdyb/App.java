package com.yanyuanquan.android.yyqdyb;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.application.ApiServiceModel;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.application.AppComponent;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.application.AppModel;
import com.yanyuanquan.android.yyqdyb.mvp.presenter.application.DaggerAppComponent;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class App extends Application {

    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        appComponent = DaggerAppComponent.builder()
                .appModel(new AppModel(this))
                .apiServiceModel(new ApiServiceModel())
                .build();

    }


    public AppComponent getAppComponent() {
        return appComponent;
    }


    private void init() {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(5)
                .memoryCacheSizePercentage(30)
                .build();
        ImageLoader.getInstance().init(configuration);
    }

    public static App getContext(Context context) {
        return (App) context.getApplicationContext();
    }


    public static DisplayImageOptions creatDefaultDisplayBuilder() {
        // 每次都要new一个, 不要定义静态变量保存
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)// 默认是false
                .cacheInMemory(true)// 是否保存到内存中。默认是false
                .cacheOnDisk(true)// 保存到SD卡中
                .considerExifParams(true)// 考虑exif信息，默认false
                .imageScaleType(ImageScaleType.NONE)// 缩放类型（不缩放）
                .bitmapConfig(Bitmap.Config.ARGB_8888)// ARGB_8888格式解析图片
                .delayBeforeLoading(100)// 延迟100毫秒加载
                .displayer(new FadeInBitmapDisplayer(300));// 渐变动画

        return builder.build();
    }
}