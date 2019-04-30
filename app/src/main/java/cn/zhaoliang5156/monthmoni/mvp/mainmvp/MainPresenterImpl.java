package cn.zhaoliang5156.monthmoni.mvp.mainmvp;

import android.os.Handler;

import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.monthmoni.base.net.HttpCallback;
import cn.zhaoliang5156.monthmoni.bean.Category;
import cn.zhaoliang5156.monthmoni.bean.CategoryResponse;
import cn.zhaoliang5156.monthmoni.bean.RightResponse;
import cn.zhaoliang5156.monthmoni.net.Api;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 10:45 AM
 * Description:
 */
public class MainPresenterImpl implements MainContract.IMainPresetner {

    private MainContract.IMainView view;
    private MainContract.IMainModel mainModel;
    private Handler mHandler = new Handler();

    public MainPresenterImpl() {
        mainModel = new MainModelImpl();
    }

    @Override
    public void attach(MainContract.IMainView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
        if (mainModel != null) {
            mainModel = null;
        }
    }

    @Override
    public void requestLeftData(String url) {
        mainModel.loadData(url, new HttpCallback() {
            @Override
            public void onSuccess(String result) {
                // result 是一个Json字符串 解析成bean
                Gson gson = new Gson();
                final CategoryResponse categoryResponse = gson.fromJson(result, CategoryResponse.class);
                // 切换到主线程，给view展示
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 调用View层
                        view.showLeft(categoryResponse.result);
                    }
                });
            }

            @Override
            public void onError(String e) {

            }
        });
    }

    @Override
    public void requestRightData(String url) {
        mainModel.loadData(url, new HttpCallback() {
            @Override
            public void onSuccess(String result) {
                // 解析二级分类
                final Gson gson = new Gson();
                CategoryResponse categoryResponse = gson.fromJson(result, CategoryResponse.class);
                // 根据二级分类请求 商品信息
                final List<Category> result1 = categoryResponse.result;


                final List<RightResponse> rightResponses = new ArrayList<>();

                mainModel.loadData(Api.SHOP_INFO + Api.SHOP_INFO_PARAM_KEYWORD + URLEncoder.encode(result1.get(0).name) + Api.SHOP_INFO_PARAM_PAGE + Api.SHOP_INFO_PARAM_COUNT, new HttpCallback() {
                    @Override
                    public void onSuccess(String result) {
                        // 解析商品信息
                        Gson gson1 = new Gson();
                        RightResponse rightResponse = gson1.fromJson(result, RightResponse.class);
                        rightResponse.category = result1.get(0).name;

                        rightResponses.add(rightResponse);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                view.showRight(rightResponses);
                            }
                        });
                    }

                    @Override
                    public void onError(String e) {

                    }
                });

            }

            @Override
            public void onError(String e) {

            }
        });
    }
}
