package cn.zhaoliang5156.monthmoni.mvp;

import java.util.List;

import cn.zhaoliang5156.monthmoni.base.mvp.BaseModel;
import cn.zhaoliang5156.monthmoni.base.mvp.BaseView;
import cn.zhaoliang5156.monthmoni.base.net.HttpCallback;
import cn.zhaoliang5156.monthmoni.bean.Category;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 8:57 AM
 * Description:
 */
public class CategoryContract {

    public interface CategoryView  {

        void showLeftData(List<Category> data);

        void showRightData(String data);
    }

    interface CategoryModel extends BaseModel {
        void loadData(String url, HttpCallback callback);
    }

    interface CategoryPresenter {

        void attach(CategoryView categoryView);

        void detach();

        void showLeftData(String url);

        void showRightData(String url);

        void changeRightData();
    }
}
