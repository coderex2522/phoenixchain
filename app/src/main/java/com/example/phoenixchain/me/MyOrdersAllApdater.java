package com.example.phoenixchain.me;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phoenixchain.R;
import com.example.phoenixchain.StringConsts;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by coderex2522 on 6/20/2017.
 */

public class MyOrdersAllApdater extends RecyclerView.Adapter<MyOrdersAllApdater.OrdersItemViewHolder>{
    private List<OrdersItemInfo> ordersItemInfoList;

    public MyOrdersAllApdater(List<OrdersItemInfo> ordersItemInfoList) {
        this.ordersItemInfoList = ordersItemInfoList;
    }

    @Override
    public OrdersItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_item,parent,false);
        OrdersItemViewHolder viewHolder = new OrdersItemViewHolder(view);
        //view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OrdersItemViewHolder holder, int position) {
        OrdersItemInfo ordersItemInfo = ordersItemInfoList.get(position);
        holder.storeNameTextView.setText(ordersItemInfo.getStoreName());
        //holder.orderStateTextView.setText(ordersItemInfo.getState());
        holder.orderStateTextView.setText("未支付");
        holder.priceTextView.setText(StringConsts.TOTAL_PRICE+String.valueOf(ordersItemInfo.getPrice()));
        holder.commodityImgView.setImageResource(R.mipmap.ic_shop);
        holder.descriptionTextView.setText(ordersItemInfo.getDescription());
    }

    @Override
    public int getItemCount() {
        return ordersItemInfoList.size();
    }

    public static class OrdersItemViewHolder extends RecyclerView.ViewHolder {
        TextView storeNameTextView;
        TextView orderStateTextView;
        ImageView commodityImgView;
        TextView descriptionTextView;
        TextView priceTextView;

        public OrdersItemViewHolder(View itemView) {
            super(itemView);
            storeNameTextView = (TextView) itemView.findViewById(R.id.tv_store_name);
            orderStateTextView = (TextView) itemView.findViewById(R.id.tv_order_state);
            commodityImgView = (ImageView) itemView.findViewById(R.id.iv_commodity);
            descriptionTextView = (TextView) itemView.findViewById(R.id.tv_description);
            priceTextView = (TextView) itemView.findViewById(R.id.tv_commodity_price);
        }
    }
}
