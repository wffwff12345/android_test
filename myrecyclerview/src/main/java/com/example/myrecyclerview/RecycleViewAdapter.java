package com.example.myrecyclerview;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

public class RecycleViewAdapter extends BaseQuickAdapter<Bean, BaseViewHolder> {
    public RecycleViewAdapter(int layoutResId, List<Bean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bean item) {
        helper.setText(R.id.tv, item.getName());
    }
}
