package com.example.myviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder> {
    private List<Bean> list = new ArrayList<>();
    public ViewPagerAdapter() {
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("jack"+i);
            list.add(bean);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager,parent,false);
        //View view = View.inflate(parent.getContext(), R.layout.item_pager, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.action_constraint);
            textView = itemView.findViewById(R.id.textTitle);
            /*textView.setOnClickListener((View v) -> {
                if (onRecycleItemClickListener != null) {
                    onRecycleItemClickListener.OnRecyclerItemClick(getAdapterPosition());
                }
            });*/
        }
    }

    /*private OnRecycleItemClickListener onRecycleItemClickListener;

    public void setOnRecycleItemClickListener(OnRecycleItemClickListener listener) {
        onRecycleItemClickListener = listener;
    }

    public interface OnRecycleItemClickListener {
        void OnRecyclerItemClick(int position);
    }*/
}
