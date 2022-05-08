package com.example.witsoverflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Post> list;

    public MyAdapter(Context context, ArrayList<Post> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Post pst = list.get(position);
        String x,y;

        holder.username.setText(pst.getusername());
        holder.post.setText(pst.getPost());
        holder.up.setText((String.valueOf(pst.getUpvote())));
        holder.down.setText((String.valueOf(pst.getDownvote())));
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView post, username, up, down;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.userName);
            post = itemView.findViewById(R.id.post);
            up = itemView.findViewById(R.id.upVoteNo);
            down = itemView.findViewById(R.id.downVoteNo);
        }
    }

}
