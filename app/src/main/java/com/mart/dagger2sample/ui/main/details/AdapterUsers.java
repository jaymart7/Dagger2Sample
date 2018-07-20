package com.mart.dagger2sample.ui.main.details;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mart.dagger2sample.R;
import com.mart.dagger2sample.model.Results;
import com.mart.dagger2sample.model.User;

import java.util.ArrayList;
import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyViewHolder> {

    private List<User> nameList = new ArrayList<>();

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    void setItems(Results results) {
        this.nameList = results.getUsersList();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User users = nameList.get(position);

        holder.tvName.setText(users.getEmail());
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
