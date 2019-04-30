package cn.zhaoliang5156.monthmoni.ui.adapter.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.zhaoliang5156.monthmoni.R;
import cn.zhaoliang5156.monthmoni.bean.ShopBean;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 11:51 AM
 * Description:
 */
public class MainRightShopInfoAdapter extends RecyclerView.Adapter<MainRightShopInfoAdapter.ViewHolder> {

    private Context context;
    private List<ShopBean> shopBeanList;

    public MainRightShopInfoAdapter(Context context, List<ShopBean> shopBeanList) {
        this.context = context;
        this.shopBeanList = shopBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.item_category_right_shopinfo, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShopBean shopBean = shopBeanList.get(position);
        holder.tvShopInfo.setText(shopBean.commodityName);
        Glide.with(context).load(shopBean.masterPic).into(holder.ivShopImage);
    }

    @Override
    public int getItemCount() {
        return shopBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivShopImage;
        private TextView tvShopInfo;

        public ViewHolder(View itemView) {
            super(itemView);

            ivShopImage = itemView.findViewById(R.id.iv_shop_image);
            tvShopInfo = itemView.findViewById(R.id.tv_shop_info);
        }
    }
}
