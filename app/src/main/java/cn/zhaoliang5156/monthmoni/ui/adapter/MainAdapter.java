package cn.zhaoliang5156.monthmoni.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 8:46 AM
 * Description:
 */
public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> pagers;
    private String[] titles = {"首页", "分类", "我的"};

    public MainAdapter(FragmentManager fm, List<Fragment> pagers) {
        super(fm);
        this.pagers = pagers;
    }

    @Override
    public Fragment getItem(int position) {
        return pagers.get(position);
    }

    @Override
    public int getCount() {
        return pagers.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
