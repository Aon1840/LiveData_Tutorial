package com.example.livedata_tutorial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.livedata_tutorial.Activity.EditContentActivity;
import com.example.livedata_tutorial.Model.User;
import com.example.livedata_tutorial.R;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.RecyclerViewHolder> {

    private List<User> userList;
//    private View.OnClickListener onClickListener;
    Context context;

    public ItemListAdapter(List<User> userList) {
        this.userList = userList;
//        this.onClickListener = onClickListener;
    }


//    Like a inflate layout => Create Layout and save data into ViewHolder
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false
        ));
    }

//    Manage the data into the ViewHolder
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final User user = userList.get(position);
        holder.tvFirstName.setText("Name: "+user.getFirstName());
        holder.tvLastName.setText("Surname: "+user.getLastName());
        holder.tvEmail.setText("Email: "+user.getEmail());
        holder.itemView.setTag(user);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, EditContentActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("data",user);
                bundle.putInt("uid",user.getUid());
                i.putExtras(bundle);
                context.startActivity(i);
            }
        });
    }

//    Get count
    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addItems(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }



    static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView tvFirstName;
        private TextView tvLastName;
        private TextView tvEmail;

        RecyclerViewHolder(View view) {
            super(view);
            tvFirstName = view.findViewById(R.id.tvFirstName);
            tvLastName = view.findViewById(R.id.tvLastName);
            tvEmail = view.findViewById(R.id.tvEmail);
        }
    }
}
