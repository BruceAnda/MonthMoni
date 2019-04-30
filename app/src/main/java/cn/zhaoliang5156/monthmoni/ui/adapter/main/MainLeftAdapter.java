package cn.zhaoliang5156.monthmoni.ui.adapter.main;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.zhaoliang5156.monthmoni.R;
import cn.zhaoliang5156.monthmoni.bean.Category;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 10:59 AM
 * Description:
 */
public class MainLeftAdapter extends RecyclerView.Adapter<MainLeftAdapter.ViewHolder> {

    private Context context;
    private List<Category> categoryList;
    private int selectPostion = 0;

    public MainLeftAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.item_category_left, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Category category = categoryList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPostion = position;
                notifyDataSetChanged();

                if (onItemClick != null) {
                    onItemClick.onLeftItemClick(category);
                }
            }
        });

        holder.category.setText(category.name);
        if (selectPostion == holder.getAdapterPosition()) {
            holder.leftIndicator.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.leftIndicator.setVisibility(View.GONE);
            holder.itemView.setBackgroundColor(Color.parseColor("#f7f7f7"));
        }

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView category;
        private View leftIndicator;

        public ViewHolder(View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.item_category_left_type);
            leftIndicator = itemView.findViewById(R.id.item_category_left_bg);
        }
    }

    private OnLeftItemClick onItemClick;

    public void setOnItemClick(OnLeftItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnLeftItemClick {
        void onLeftItemClick(Category category);
    }
}
