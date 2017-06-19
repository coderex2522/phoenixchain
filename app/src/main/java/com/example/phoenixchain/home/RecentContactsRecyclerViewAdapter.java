package com.example.phoenixchain.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phoenixchain.R;

import java.util.List;

/**
 * Created by coderex2522 on 6/19/2017.
 */

public class RecentContactsRecyclerViewAdapter extends RecyclerView.Adapter<RecentContactsRecyclerViewAdapter.RecentContactsViewHolder>
                                                implements  View.OnClickListener{
    private List<RecentContacts> recentContactsList;
    private OnItemClickListener onItemClickListener;


    public RecentContactsRecyclerViewAdapter(List<RecentContacts> recentContactsList) {
        this.recentContactsList = recentContactsList;
    }

    @Override
    public RecentContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_contacts_item,parent,false);
        RecentContactsViewHolder viewHolder = new RecentContactsViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecentContactsViewHolder holder, int position) {
        RecentContacts recentContactsItem = recentContactsList.get(position);
        holder.imageView.setImageResource(recentContactsItem.getHeadSculptureImgId());
        holder.nameTextView.setText(recentContactsItem.getName());
        holder.phoneTextView.setText(recentContactsItem.getPhoneNum());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return recentContactsList.size();
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener != null){
            onItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public static interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    public static class RecentContactsViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nameTextView;
        TextView phoneTextView;

        public RecentContactsViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_recent_contacts);
            nameTextView = (TextView) itemView.findViewById(R.id.tv_recent_contacts_name);
            phoneTextView = (TextView) itemView.findViewById(R.id.tv_recent_contacts_phone);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
