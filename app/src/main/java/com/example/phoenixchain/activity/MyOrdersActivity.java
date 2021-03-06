package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.phoenixchain.OnItemClickListener;
import com.example.phoenixchain.R;
import com.example.phoenixchain.StringConsts;
import com.example.phoenixchain.TitleConsts;
import com.example.phoenixchain.adapter.MyOrdersAllApdater;
import com.example.phoenixchain.bean.OrdersItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coderex2522 on 6/20/2017.
 */

public class MyOrdersActivity extends BaseActivity {
    private RecyclerView myOrdersRV;
    private List<OrdersItemInfo> ordersItemInfoList;

    private void initOrdersList(){
        ordersItemInfoList = new ArrayList<OrdersItemInfo>();
        OrdersItemInfo ordersItemInfo=new OrdersItemInfo("园博园服饰商城","园博园购票大全",60.0,R.mipmap.ic_shop,0);
        ordersItemInfoList.add(ordersItemInfo);
        OrdersItemInfo ordersItemInfo1=new OrdersItemInfo("园博园服饰商城1","园博园购票大全1",50.0,R.mipmap.ic_shop,1);
        ordersItemInfoList.add(ordersItemInfo1);
        OrdersItemInfo ordersItemInfo2=new OrdersItemInfo("园博园服饰商城2","园博园购票大全2",40.0,R.mipmap.ic_shop,2);
        ordersItemInfoList.add(ordersItemInfo2);
        OrdersItemInfo ordersItemInfo3=new OrdersItemInfo("园博园服饰商城3","园博园购票大全3",30.0,R.mipmap.ic_shop,1);
        ordersItemInfoList.add(ordersItemInfo3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        initTitleAndToolbar(R.id.include_tb_my_orders,TitleConsts.MY_ORFERS_TITLE);
        initOrdersList();
        //init the widget
        myOrdersRV = (RecyclerView) findViewById(R.id.rv_my_orders);

        //set the recyclerview of all orders
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        myOrdersRV.setLayoutManager(linearLayoutManager);
        MyOrdersAllApdater myOrdersAllApdater = new MyOrdersAllApdater(ordersItemInfoList);
        myOrdersRV.setAdapter(myOrdersAllApdater);
        myOrdersAllApdater.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MyOrdersActivity.this,OrderDetailActivity.class);
                switch (ordersItemInfoList.get(position).getState()){
                    case 0:
                        intent.putExtra(StringConsts.ORDER_ITEM_DETAIL,StringConsts.PAY_ITEM);
                        break;
                    case 1:
                        intent.putExtra(StringConsts.ORDER_ITEM_DETAIL,StringConsts.DRAWBACK_ITEM);
                        break;
                    case 2:
                        intent.putExtra(StringConsts.ORDER_ITEM_DETAIL,StringConsts.PAY_AGAIN_ITEM);
                        break;
                }
                startActivity(intent);
            }
        });

    }
}
