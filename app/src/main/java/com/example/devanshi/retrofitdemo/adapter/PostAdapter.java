package com.example.devanshi.retrofitdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.devanshi.retrofitdemo.util.CustomItemClickListener;
import com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.ShowMoreDataActivity;
import com.example.devanshi.retrofitdemo.model.Post;

import java.util.List;

/**
 * Created by Devanshi on 05-03-2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    List<Post.DataBean.BasketsBean> list;
    Context context;
    CustomItemClickListener listener;


    public PostAdapter(Context context, List<Post.DataBean.BasketsBean> list) {
        this.context = (Context) context;
        this.list = list;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.retro_post_demo_row, parent, false);
        final PostAdapter.MyViewHolder viewHolder = new PostAdapter.MyViewHolder(itemView);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final Post.DataBean.BasketsBean basketsBean = list.get(position);
        holder.setIsRecyclable(false);

        Glide.with(context).load(list.get(position).getB_logo()).into(holder.image);
        holder.title.setText(basketsBean.getB_name());
        holder.intro.setText(basketsBean.getB_intro());
        holder.showmore.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String titlevalue=holder.title.getText().toString();
                String infovalue=holder.intro.getText().toString();
               // Log.d("hey","value of title"+titlevalue);
                Intent i=new Intent(context,ShowMoreDataActivity.class);
                i.putExtra("title",titlevalue);
                i.putExtra("Info",infovalue);

                    context.startActivity(i);
            }
        });
     //   holder.bind(position);

//        holder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (list.get(position).getChecked()) {
//                    //holder.chk.setChecked(false);
//                    list.get(position).setChecked(false);
//                    holder.intro.setVisibility(View.GONE);} else {
//                   //holder.chk.setChecked(true);
//                    list.get(position).setChecked(true);
//                    holder.intro.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
////        holder.chk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (list.get(position).getChecked()) {
//                    //holder.chk.setChecked(false);
//                    list.get(position).setChecked(false);
//                    holder.intro.setVisibility(View.GONE);
//                } else {
//                    //holder.chk.setChecked(true);
//                    list.get(position).setChecked(true);
//                    holder.intro.setVisibility(View.VISIBLE);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView title, intro,showmore;
       // CheckBox chk;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            this.setIsRecyclable(false);
            image = itemView.findViewById(R.id.row_image);
            title = itemView.findViewById(R.id.row_title);
            intro = itemView.findViewById(R.id.row_intro);
            showmore=itemView.findViewById(R.id.show_more_row);
           // chk = itemView.findViewById(R.id.checkbox);


        }

//        public void bind(int position)
//        {
//            if (list.get(position).getChecked())
//            {
//                chk.setChecked(true);
//                intro.setVisibility(View.VISIBLE);
//            }
//            else
//            {
//                chk.setChecked(false);
//                intro.setVisibility(View.GONE);
//            }
//        }
    }

}
