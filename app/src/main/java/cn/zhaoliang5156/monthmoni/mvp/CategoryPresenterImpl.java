package cn.zhaoliang5156.monthmoni.mvp;

import android.os.Handler;

import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;

import cn.zhaoliang5156.monthmoni.base.net.HttpCallback;
import cn.zhaoliang5156.monthmoni.bean.Category;
import cn.zhaoliang5156.monthmoni.bean.CategoryResponse;
import cn.zhaoliang5156.monthmoni.bean.RightResponse;
import cn.zhaoliang5156.monthmoni.net.Api;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 8:55 AM
 * Description:
 */
public class CategoryPresenterImpl implements CategoryContract.CategoryPresenter {

    private CategoryContract.CategoryView view;
    private CategoryModelImpl model;
    private Handler mHandler = new Handler();

    @Override
    public void attach(CategoryContract.CategoryView categoryView) {
        this.view = categoryView;
        model = new CategoryModelImpl();
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void showLeftData(String url) {
        model.loadData(url, new HttpCallback() {
            @Override
            public void onSuccess(String result) {
                // 解析数据
                Gson gson = new Gson();
                final CategoryResponse fristCategoryResponse = gson.fromJson(result, CategoryResponse.class);

                // 切换到主线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.showLeftData(fristCategoryResponse.result);
                    }
                });
            }

            @Override
            public void onError(String e) {

            }
        });
    }

    @Override
    public void showRightData(String url) {
        model.loadData(url, new HttpCallback() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                CategoryResponse categoryResponse = gson.fromJson(result, CategoryResponse.class);
                // 根据二级分类 请求二级商品信息
                List<Category> result1 = categoryResponse.result;
                for (Category category : result1) {
                    model.loadData(Api.SHOP_INFO + Api.SHOP_INFO_PARAM_KEYWORD + URLEncoder.encode(category.name) + Api.SHOP_INFO_PARAM_PAGE + Api.SHOP_INFO_PARAM_COUNT, new HttpCallback() {
                        @Override
                        public void onSuccess(final String result) {
                            Gson gson1 = new Gson();
                            RightResponse rightResponse = gson1.fromJson(result, RightResponse.class);

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //view.showRightData(result);
                                }
                            });
                        }

                        @Override
                        public void onError(String e) {

                        }
                    });

                }
            }

            @Override
            public void onError(String e) {

            }
        });
    }

    @Override
    public void changeRightData() {

    }
}
