package cn.zhaoliang5156.monthmoni.config;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 3:04 PM
 * Description:
 */
@GlideModule
public class MyAppClideModel extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        //super.applyOptions(context, builder);
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, getStorageDirectory() + "/myshopcache", 1024 * 1024 * 100));
    }


    //外部路径
    private String sdRootPath = Environment.getExternalStorageDirectory().getPath();
    private String appRootPath = null;

    private String getStorageDirectory() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ?
                sdRootPath : appRootPath;

    }
}
