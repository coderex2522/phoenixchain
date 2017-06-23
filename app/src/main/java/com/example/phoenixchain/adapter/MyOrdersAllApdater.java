package com.example.phoenixchain.adapter;

import android.content.Intent;
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
import com.example.phoenixchain.bean.OrdersItemInfo;
import com.example.phoenixchain.activity.ApplyDrawbackActivity;
import com.example.phoenixchain.activity.PaymentMethodsActivity;

import java.util.List;

/**
 * Created by coderex2522 on 6/20/2017.
 */

public class MyOrdersAllApdater extends RecyclerView.Adapter<MyOrdersAllApdater.OrdersItemViewHolder>
                                            implements View.OnClickListener{
    private List<OrdersItemInfo> ordersItemInfoList;
    private OnItemClickListener onItemClickListener;

    private View.OnClickListener assessOrderClickListener;
    private View.OnClickListener payClickListener;
    private View.OnClickListener drawbackClickListener;
    private View.OnClickListener shopAgainClickListener;

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

        payClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(),"require pay",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), PaymentMethodsActivity.class);
                v.getContext().startActivity(intent);
            }
        };

        drawbackClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ApplyDrawbackActivity.class);
                v.getContext().startActivity(intent);
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
                holder.changeBtn.setText(StringConsts.GO_PAY);
                holder.changeBtn.setOnClickListener(payClickListener);
                holder.assessOrderBtn.setVisibility(View.INVISIBLE);
                break;
            case 1:
                holder.changeBtn.setText(StringConsts.DRAWBACK);
                holder.changeBtn.setOnClickListener(drawbackClickListener);
                holder.assessOrderBtn.setVisibility(View.INVISIBLE);
                break;
            case 2:
                holder.changeBtn.setText(StringConsts.SHOP_AGAIN);
                holder.changeBtn.setOnClickListener(shopAgainClickListener);
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
        Button assessOrderBtn;
        Button changeBtn;

        public OrdersItemViewHolder(View itemView) {
            super(itemView);
            storeNameTextView = (TextView) itemView.findViewById(R.id.tv_store_name);
            orderStateTextView = (TextView) itemView.findViewById(R.id.tv_order_state);
            commodityImgView = (ImageView) itemView.findViewById(R.id.iv_commodity);
            descriptionTextView = (TextView) itemView.findViewById(R.id.tv_description);
            priceTextView = (TextView) itemView.findViewById(R.id.tv_commodity_price);
            assessOrderBtn = (Button) itemView.findViewById(R.id.btn_assess_order);
            changeBtn = (Button) itemView.findViewById(R.id.btn_change);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
