package cn.zhaoliang5156.monthmoni.app;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

import cn.zhaoliang5156.monthmoni.net.VolleyHttpImpl;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/27 8:05 PM
 * Description:
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VolleyHttpImpl.create(this);

        UMConfigure.init(this, "5cc7fc670cafb2065a000537", "360", UMConfigure.DEVICE_TYPE_PHONE, "");
    }
}
