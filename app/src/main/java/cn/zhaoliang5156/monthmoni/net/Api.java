package cn.zhaoliang5156.monthmoni.net;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 9:13 AM
 * Description:
 */
public class Api {

    public static String FIRST_CATEGORY = "http://172.17.8.100/small/commodity/v1/findFirstCategory";

    public static String SECOND_CATEFORY = "http://172.17.8.100/small/commodity/v1/findSecondCategory?";
    public static String SECOND_CATEGORY_PARAM = "firstCategoryId=";

    public static String SHOP_INFO = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?";
    public static String SHOP_INFO_PARAM_KEYWORD = "keyword=";
    public static String SHOP_INFO_PARAM_PAGE = "&page=1";
    public static String SHOP_INFO_PARAM_COUNT = "&count=6";

}
