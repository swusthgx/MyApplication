package com.malata.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by huangguoxiong on 15-7-20.
 */
public class MyAtapter extends RecyclerView.Adapter<MyAtapter.ViewHolder> {

    // 数据集
    private String[] mDataset;

    public MyAtapter(String[] dataset) {
        super();
        mDataset = dataset;
    }



    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return  mDataset.length;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        // TODO Auto-generated method stub
        // 绑定数据到ViewHolder上
        viewHolder.mTextView.setText(mDataset[i]);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // TODO Auto-generated method stub
        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
        View view = View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null);
        // 创建一个ViewHolder
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
