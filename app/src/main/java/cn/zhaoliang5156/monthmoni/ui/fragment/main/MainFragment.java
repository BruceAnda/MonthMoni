package cn.zhaoliang5156.monthmoni.ui.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.zhaoliang5156.monthmoni.R;
import cn.zhaoliang5156.monthmoni.bean.Category;
import cn.zhaoliang5156.monthmoni.bean.RightResponse;
import cn.zhaoliang5156.monthmoni.mvp.mainmvp.MainContract;
import cn.zhaoliang5156.monthmoni.mvp.mainmvp.MainPresenterImpl;
import cn.zhaoliang5156.monthmoni.net.Api;
import cn.zhaoliang5156.monthmoni.ui.adapter.main.MainLeftAdapter;
import cn.zhaoliang5156.monthmoni.ui.adapter.main.MainRightAdapter;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/3/21 1:46 PM
 * Description:    我们在首页实现分类
 */
public class MainFragment extends Fragment implements MainContract.IMainView, MainLeftAdapter.OnLeftItemClick {

    private RecyclerView mainLeft;
    private RecyclerView mainRight;

    private MainContract.IMainPresetner mainPresetner;
    private MainLeftAdapter adapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mainLeft = view.findViewById(R.id.main_left);
        // 指定线性布局管理器
        mainLeft.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainRight = view.findViewById(R.id.main_right);
        // 指定右侧布局管理器
        mainRight.setLayoutManager(new LinearLayoutManager(getActivity()));

        mainPresetner = new MainPresenterImpl();
        mainPresetner.attach(this);

        mainPresetner.requestLeftData(Api.FIRST_CATEGORY);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mainPresetner.detach();
    }

    @Override
    public void showLeft(List<Category> categories) {
        // 展示数据
        adapter = new MainLeftAdapter(getActivity(), categories);
        adapter.setOnItemClick(this);
        mainLeft.setAdapter(adapter);

        // 请求第一个的二级分类
        mainPresetner.requestRightData(Api.SECOND_CATEFORY + Api.SECOND_CATEGORY_PARAM + categories.get(0).id);
    }

    @Override
    public void showRight(List<RightResponse> rightResponse) {
        mainRight.setAdapter(new MainRightAdapter(getActivity(), rightResponse));
    }

    @Override
    public void onLeftItemClick(Category category) {
        // 请求第一个的二级分类
        mainPresetner.requestRightData(Api.SECOND_CATEFORY + Api.SECOND_CATEGORY_PARAM + category.id);
    }
}
