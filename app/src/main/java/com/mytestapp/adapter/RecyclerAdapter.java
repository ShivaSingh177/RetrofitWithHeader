package com.mytestapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List recyclerList;
    Context context;
    int layout, from;
    ReturnView returnView;

    public RecyclerAdapter(List recyclerList, Context context, int layout, ReturnView returnView, int from) {
        this.recyclerList = recyclerList;
        this.context = context;
        this.layout = layout;
        this.returnView = returnView;
        this.from = from;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        returnView.getAdapterView(holder.view,recyclerList,position,from);
    }

    @Override
    public int getItemCount() {
        return recyclerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.view=itemView;
        }
    }


    public interface ReturnView {
        void getAdapterView(View view, List object, int position, int from);
    }

}
