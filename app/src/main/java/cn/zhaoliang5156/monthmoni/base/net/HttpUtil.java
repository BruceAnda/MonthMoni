package cn.zhaoliang5156.monthmoni.base.net;

import java.util.Map;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/27 7:57 PM
 * Description:
 */
public interface HttpUtil {

    void doHttp(int method, String url, Map<String, String> param, HttpCallback callback);
}
