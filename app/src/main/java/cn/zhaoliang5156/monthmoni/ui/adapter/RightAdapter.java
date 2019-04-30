package cn.zhaoliang5156.monthmoni.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/4/30 10:18 AM
 * Description:
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHodler> {



    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHodler extends RecyclerView.ViewHolder {

        public ViewHodler(View itemView) {
            super(itemView);
        }
    }
}
