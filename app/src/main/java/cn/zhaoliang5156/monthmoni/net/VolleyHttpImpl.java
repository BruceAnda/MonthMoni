package cn.zhaoliang5156.monthmoni.net;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

import cn.zhaoliang5156.monthmoni.base.net.HttpCallback;
import cn.zhaoliang5156.monthmoni.base.net.HttpUtil;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/27 7:59 PM
 * Description:
 */
public class VolleyHttpImpl implements HttpUtil {

    private static VolleyHttpImpl instance = null;

    private RequestQueue queue;

    private VolleyHttpImpl(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("初始化的时候，content不能是null");
        }
        queue = Volley.newRequestQueue(context);
    }

    public static VolleyHttpImpl create(Context context) {
        if (instance == null) {
            synchronized (VolleyHttpImpl.class) {
                instance = new VolleyHttpImpl(context);
            }
        }
        return instance;
    }

    public static VolleyHttpImpl getInstance() {
        return create(null);
    }

    @Override
    public void doHttp(int method, String url, final Map<String, String> param, final HttpCallback callback) {
        StringRequest request = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return param;
            }
        };
        queue.add(request);
    }
}
