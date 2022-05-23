package com.example.witsoverflow;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Post> list;
    TextView post, unam;

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
  
