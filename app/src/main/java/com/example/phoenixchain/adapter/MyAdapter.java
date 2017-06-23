package com.example.phoenixchain.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phoenixchain.R;
import com.example.phoenixchain.bean.TransactionInfo;

import java.util.List;

/**
 * Created by Sanji on 2017/6/20.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener{

    private List<TransactionInfo> transactionInfoList;

    public MyAdapter(List<TransactionInfo> transactionInfoList){
        this.transactionInfoList=transactionInfoList;
    }
    private OnItemClickListener mOnItemClickListener=null;

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_transaction_record, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTextView_data.setText(transactionInfoList.get(position).getData().toString());
        viewHolder.mTextView_sum.setText((String.valueOf(transactionInfoList.get(position).getSum())));
        viewHolder.mTextView_towhom.setText(transactionInfoList.get(position).getToWhom().toString());
        viewHolder.mTextView_type.setText(transactionInfoList.get(position).getType().toString());
        viewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {

        return transactionInfoList.size();
    }

    @Override
    public void onClick(View v) {
        if(mOnItemClickListener != null){
            mOnItemClickListener.onItemClick(v, (int)v.getTag());
        }

    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView_data;
        public TextView mTextView_sum;
        public TextView mTextView_towhom;
        public TextView mTextView_type;

        public ViewHolder(View view){
            super(view);
            mTextView_data = (TextView) view.findViewById(R.id.tv_date);
            mTextView_sum = (TextView) view.findViewById(R.id.tv_sum);
            mTextView_towhom = (TextView) view.findViewById(R.id.tv_towhom);
            mTextView_type = (TextView) view.findViewById(R.id.tv_type);
        }
    }
}
