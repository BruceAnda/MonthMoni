package cn.zhaoliang5156.monthmoni.ui.adapter;

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
 * Date: 2019/4/30 9:23 AM
 * Description:
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHodler> {

    private Context context;
    private List<Category> data;
    private int selectionPostion = 0;

    public LeftAdapter(Context context, List<Category> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHodler(View.inflate(context, R.layout.item_category_left, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, final int position) {
        final Category firstCategory = data.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionPostion = position;
                notifyDataSetChanged();
                if (onCategoryItemClick != null) {
                    onCategoryItemClick.onItemClick(firstCategory);
                }
            }
        });
        if (selectionPostion == holder.getAdapterPosition()) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.left.setVisibility(View.VISIBLE);
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#f7f7f7"));
            holder.left.setVisibility(View.INVISIBLE);
        }
        holder.category.setText(firstCategory.name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder {

        private TextView category;
        private View left;

        public ViewHodler(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.item_category_left_type);
            left = itemView.findViewById(R.id.item_category_left_bg);
        }
    }

    private OnCategoryItemClick onCategoryItemClick;

    public void setOnCategoryItemClick(OnCategoryItemClick onCategoryItemClick) {
        this.onCategoryItemClick = onCategoryItemClick;
    }

    public interface OnCategoryItemClick {
        void onItemClick(Category firstCategory);
    }

}
