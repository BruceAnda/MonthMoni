package cn.zhaoliang5156.monthmoni.ui.activity;

import android.Manifest;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.monthmoni.R;
import cn.zhaoliang5156.monthmoni.ui.adapter.MainAdapter;
import cn.zhaoliang5156.monthmoni.ui.fragment.category.CategoryFragment;
import cn.zhaoliang5156.monthmoni.ui.fragment.main.MainFragment;
import cn.zhaoliang5156.monthmoni.ui.fragment.MyFragment;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/3/21 1:46 PM
 * Description:
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TabLayout mainTab;
    private ViewPager mainPager;
    private List<Fragment> pagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?";
        String keyword = URLEncoder.encode("手机");
        int page = 1;
        int count = 5;
        String compeleteUrl = url + "keyword=" + keyword + "&page=" + page + "&count=" + count;
        VolleyHttpImpl.getInstance().doHttp(Request.Method.GET, compeleteUrl, null, new HttpCallback() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, result);
            }

            @Override
            public void onError(String e) {
                Log.i(TAG, e);
            }
        });*/

        mainTab = findViewById(R.id.main_tab);
        mainPager = findViewById(R.id.main_pager);

        pagers = new ArrayList<>();
        pagers.add(new MainFragment());
        pagers.add(new CategoryFragment());
        pagers.add(new MyFragment());

        mainPager.setAdapter(new MainAdapter(getSupportFragmentManager(), pagers));
        mainTab.setupWithViewPager(mainPager);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x00);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
