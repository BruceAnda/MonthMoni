package cn.zhaoliang5156.monthmoni.base.net;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/27 7:57 PM
 * Description:
 */
public interface HttpCallback {

    void onSuccess(String result);

    void onError(String e);
}
