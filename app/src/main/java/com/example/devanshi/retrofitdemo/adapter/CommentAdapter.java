package com.example.devanshi.retrofitdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.model.Comment;

import java.util.List;

/**
 * Created by Devanshi on 01-03-2018.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder>
{
    List<Comment> list;

    public CommentAdapter(List<Comment> list)
    {
        this.list=list;
    }

    @Override
    public CommentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_row, parent, false);
        final CommentAdapter.MyViewHolder viewHolder = new CommentAdapter.MyViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommentAdapter.MyViewHolder holder, int position)
    {

        Comment comment=list.get(position);
        holder.id.setText(String.valueOf(comment.getId()));
        holder.postid.setText(String.valueOf(comment.getPostId()));
        holder.name.setText(comment.getName());
        holder.body.setText(comment.getBody());
        holder.email.setText(comment.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView postid,id,name,email,body;
        public MyViewHolder(View itemView) {
            super(itemView);
            postid=itemView.findViewById(R.id.tvPostId);
            id=itemView.findViewById(R.id.tvCommentId);
            name=itemView.findViewById(R.id.tvName);
            email=itemView.findViewById(R.id.tvEmail);
            body=itemView.findViewById(R.id.tvCommentBody);
        }
    }
}
