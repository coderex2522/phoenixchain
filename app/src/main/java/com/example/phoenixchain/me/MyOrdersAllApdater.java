package com.example.phoenixchain.me;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixchain.OnItemClickListener;
import com.example.phoenixchain.R;
import com.example.phoenixchain.StringConsts;

import java.util.List;

/**
 * Created by coderex2522 on 6/20/2017.
 */

public class MyOrdersAllApdater extends RecyclerView.Adapter<MyOrdersAllApdater.OrdersItemViewHolder>
                                            implements View.OnClickListener{
    private List<OrdersItemInfo> ordersItemInfoList;
    private OnItemClickListener onItemClickListener;

    private View.OnClickListener assessOrderClickListener;
    private View.OnClickListener cancelOrderClickListener;
    private View.OnClickListener requirePayClickListener;
    private View.OnClickListener drawbackClickListener;

    private String orderStates[]=new String[]{
        "未支付","已支付","待评价"
    };

    private void initClickListener(){
        assessOrderClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"assess order",Toast.LENGTH_SHORT).show();
            }
        };

        cancelOrderClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"cancel order",Toast.LENGTH_SHORT).show();
            }
        };

        requirePayClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"require pay",Toast.LENGTH_SHORT).show();
            }
        };

        drawbackClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"drawback",Toast.LENGTH_SHORT).show();
            }
        };

    }

    public MyOrdersAllApdater(List<OrdersItemInfo> ordersItemInfoList) {
        this.ordersItemInfoList = ordersItemInfoList;
        initClickListener();
    }

    @Override
    public OrdersItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orders,parent,false);
        OrdersItemViewHolder viewHolder = new OrdersItemViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OrdersItemViewHolder holder, int position) {
        OrdersItemInfo ordersItemInfo = ordersItemInfoList.get(position);
        holder.storeNameTextView.setText(ordersItemInfo.getStoreName());
        //holder.orderStateTextView.setText(ordersItemInfo.getState());
        holder.orderStateTextView.setText(orderStates[ordersItemInfo.getState()]);
        holder.priceTextView.setText(StringConsts.TOTAL_PRICE+String.valueOf(ordersItemInfo.getPrice()));
        holder.commodityImgView.setImageResource(R.mipmap.ic_shop);
        holder.descriptionTextView.setText(ordersItemInfo.getDescription());
        holder.itemView.setTag(position);
        switch (ordersItemInfo.getState()){
            case 0:
                holder.changeBtn.setText(StringConsts.CANCEL_ORDER);
                holder.changeBtn.setOnClickListener(cancelOrderClickListener);
                holder.requirePayBtn.setOnClickListener(requirePayClickListener);
                break;
            case 1:
                holder.changeBtn.setText(StringConsts.DRAWBACK);
                holder.changeBtn.setOnClickListener(drawbackClickListener);
                holder.requirePayBtn.setVisibility(View.INVISIBLE);
                break;
            case 2:
                holder.changeBtn.setText(StringConsts.ASSESS_ORDER);
                holder.changeBtn.setOnClickListener(assessOrderClickListener);
                holder.requirePayBtn.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return ordersItemInfoList.size();
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener != null){
            onItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public static class OrdersItemViewHolder extends RecyclerView.ViewHolder {
        TextView storeNameTextView;
        TextView orderStateTextView;
        ImageView commodityImgView;
        TextView descriptionTextView;
        TextView priceTextView;
        Button requirePayBtn;
        Button changeBtn;

        public OrdersItemViewHolder(View itemView) {
            super(itemView);
            storeNameTextView = (TextView) itemView.findViewById(R.id.tv_store_name);
            orderStateTextView = (TextView) itemView.findViewById(R.id.tv_order_state);
            commodityImgView = (ImageView) itemView.findViewById(R.id.iv_commodity);
            descriptionTextView = (TextView) itemView.findViewById(R.id.tv_description);
            priceTextView = (TextView) itemView.findViewById(R.id.tv_commodity_price);
            requirePayBtn = (Button) itemView.findViewById(R.id.btn_require_pay);
            changeBtn = (Button) itemView.findViewById(R.id.btn_change);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
