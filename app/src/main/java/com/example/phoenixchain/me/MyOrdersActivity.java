package com.example.phoenixchain.me;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.phoenixchain.ChildActivity;
import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coderex2522 on 6/20/2017.
 */

public class MyOrdersActivity extends ChildActivity {
    private RecyclerView myOrdersRV;
    private List<OrdersItemInfo> ordersItemInfoList;

    private void initOrdersList(){
        ordersItemInfoList = new ArrayList<OrdersItemInfo>();
        OrdersItemInfo ordersItemInfo=new OrdersItemInfo("园博园服饰商城","园博园购票大全",60.0,R.mipmap.ic_shop,2);
        ordersItemInfoList.add(ordersItemInfo);
        OrdersItemInfo ordersItemInfo1=new OrdersItemInfo("园博园服饰商城1","园博园购票大全1",50.0,R.mipmap.ic_shop,2);
        ordersItemInfoList.add(ordersItemInfo1);
        OrdersItemInfo ordersItemInfo2=new OrdersItemInfo("园博园服饰商城2","园博园购票大全2",40.0,R.mipmap.ic_shop,2);
        ordersItemInfoList.add(ordersItemInfo2);
        OrdersItemInfo ordersItemInfo3=new OrdersItemInfo("园博园服饰商城3","园博园购票大全3",30.0,R.mipmap.ic_shop,2);
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
    }
}
