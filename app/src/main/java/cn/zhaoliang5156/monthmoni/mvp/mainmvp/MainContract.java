package cn.zhaoliang5156.monthmoni.mvp.mainmvp;

import java.util.List;

import cn.zhaoliang5156.monthmoni.base.net.HttpCallback;
import cn.zhaoliang5156.monthmoni.bean.Category;
import cn.zhaoliang5156.monthmoni.bean.RightResponse;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 10:39 AM
 * Description: 首页分类的契约接口
 */
public interface MainContract {

    /*
    V:
    P:
    M:
     */
    interface IMainView {
        void showLeft(List<Category> categoryList);

        void showRight(List<RightResponse> rightResponse);
    }

    interface IMainModel {
        void loadData(String url, HttpCallback callback);
    }

    interface IMainPresetner {

        void attach(IMainView view);

        void detach();

        void requestLeftData(String url);

        void requestRightData(String url);
    }
}
