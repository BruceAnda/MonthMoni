package cn.zhaoliang5156.monthmoni.mvp;


import com.android.volley.Request;

import cn.zhaoliang5156.monthmoni.base.net.HttpCallback;
import cn.zhaoliang5156.monthmoni.net.VolleyHttpImpl;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 8:56 AM
 * Description:
 */
public class CategoryModelImpl implements CategoryContract.CategoryModel {

    private VolleyHttpImpl volleyHttp;

    public CategoryModelImpl() {
        volleyHttp = VolleyHttpImpl.getInstance();
    }

    @Override
    public void loadData(String url, HttpCallback callback) {
        volleyHttp.doHttp(Request.Method.GET, url, null, callback);
    }
}
