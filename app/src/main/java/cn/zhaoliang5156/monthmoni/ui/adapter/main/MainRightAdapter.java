package cn.zhaoliang5156.monthmoni.ui.adapter.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.zhaoliang5156.monthmoni.R;
import cn.zhaoliang5156.monthmoni.bean.RightResponse;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 11:40 AM
 * Description:
 */
public class MainRightAdapter extends RecyclerView.Adapter<MainRightAdapter.ViewHodler> {

    private Context context;
    private List<RightResponse> responseList;

    public MainRightAdapter(Context context, List<RightResponse> responseList) {
        this.context = context;
        this.responseList = responseList;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHodler(View.inflate(context, R.layout.item_category_right, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        RightResponse rightResponse = responseList.get(position);
        holder.secondCategory.setText(rightResponse.category);
        holder.rvShopInfo.setAdapter(new MainRightShopInfoAdapter(context, rightResponse.result));
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder {

        private TextView secondCategory;
        private RecyclerView rvShopInfo;

        public ViewHodler(View itemView) {
            super(itemView);
            secondCategory = itemView.findViewById(R.id.tv_second_category);
            rvShopInfo = itemView.findViewById(R.id.rv_shop_info);
            rvShopInfo.setLayoutManager(new GridLayoutManager(context, 3));
        }
    }
}
