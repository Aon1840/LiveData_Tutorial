package com.example.livedata_tutorial.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.livedata_tutorial.Database.User;
import com.example.livedata_tutorial.R;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.RecyclerViewHolder> {

    private List<User> userList;
    private View.OnClickListener onClickListener;

    public ItemListAdapter(List<User> userList, View.OnClickListener onClickListener) {
        this.userList = userList;
        this.onClickListener = onClickListener;
    }


//    Like a inflate layout
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        User user = userList.get(position);
        holder.tvFirstName.setText(user.getFirstName());
        holder.tvLastName.setText(user.getLastName());
        holder.tvEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addItems(List<User> user){
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
