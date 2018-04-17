package com.example.devanshi.retrofitdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.devanshi.retrofitdemo.util.CustomItemClickListener;
import com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.model.PostResponse;

import java.util.List;

/**
 * Created by Devanshi on 28-02-2018.
 */

public class RetroRecyclerAdapter extends RecyclerView.Adapter<RetroRecyclerAdapter.MyViewHolder>
{
    List<PostResponse> list;
    CustomItemClickListener listener;
   // List<User> contacts;
    Context context;

    public RetroRecyclerAdapter(List<PostResponse> list)
    {
        this.list=list;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.retro_row, parent, false);
           final RetroRecyclerAdapter.MyViewHolder viewHolder = new RetroRecyclerAdapter.MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, viewHolder.getPosition());
            }
        });
            return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        PostResponse response=list.get(position);
        holder.id.setText(String.valueOf(response.getId()));
        holder.userid.setText(String.valueOf(response.getUserId()));
        holder.title.setText(response.getTitle());
        holder.body.setText(response.getBody());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public RetroRecyclerAdapter(Context mContext, List<PostResponse> data, CustomItemClickListener listener) {
        this.list = data;
        this.context = mContext;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView id,userid,title,body;
        public MyViewHolder(View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.tvId);
            userid=itemView.findViewById(R.id.tvUserId);
            title=itemView.findViewById(R.id.tvTitle);
            body=itemView.findViewById(R.id.tvBody);
        }
    }
}
