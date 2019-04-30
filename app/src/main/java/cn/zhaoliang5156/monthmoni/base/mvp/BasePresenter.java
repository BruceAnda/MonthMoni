package cn.zhaoliang5156.monthmoni.base.mvp;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/27 8:54 PM
 * Description:
 */
public abstract class BasePresenter<V> {

    protected V v;

    public void attachView(V v) {

    }

    public void detachView(V v) {
        
    }
}
