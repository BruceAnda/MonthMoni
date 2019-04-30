package cn.zhaoliang5156.monthmoni.ui.fragment.category;


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
import cn.zhaoliang5156.monthmoni.mvp.CategoryContract;
import cn.zhaoliang5156.monthmoni.mvp.CategoryPresenterImpl;
import cn.zhaoliang5156.monthmoni.net.Api;
import cn.zhaoliang5156.monthmoni.ui.adapter.LeftAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryContract.CategoryView, LeftAdapter.OnCategoryItemClick {

    private RecyclerView leftCategory;
    private RecyclerView rightCategory;
    private CategoryPresenterImpl presenter;
    private LeftAdapter adapter;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        leftCategory = view.findViewById(R.id.left_category);
        leftCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rightCategory = view.findViewById(R.id.right_category);

        presenter = new CategoryPresenterImpl();
        presenter.attach(this);
        presenter.showLeftData(Api.FIRST_CATEGORY);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void showLeftData(List<Category> data) {
        adapter = new LeftAdapter(getActivity(), data);
        adapter.setOnCategoryItemClick(this);
        leftCategory.setAdapter(adapter);
        // 请求初始二级分类
        presenter.showRightData(Api.SECOND_CATEFORY + Api.SECOND_CATEGORY_PARAM + data.get(0).id);
    }

    @Override
    public void showRightData(String data) {

    }

    @Override
    public void onItemClick(Category firstCategory) {
        presenter.showRightData(Api.SECOND_CATEFORY + Api.SECOND_CATEGORY_PARAM + firstCategory.id);
    }
}
