package com.example.phoenixchain.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.phoenixchain.R;
import com.example.phoenixchain.StringConsts;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by coderex2522 on 6/21/2017.
 */

public class OrderDetailActivity extends BaseActivity {
    private Button changeLeftBtn;
    private Button changeRightBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initTitleAndToolbar(R.id.include_tb_order_detail, TitleConsts.ORDER_DETAIL_TITLE);
        String activityType = getIntent().getStringExtra(StringConsts.ORDER_ITEM_DETAIL);
        changeLeftBtn = (Button) findViewById(R.id.btn_od_change_left);
        changeRightBtn = (Button) findViewById(R.id.btn_od_change_right);

        if(StringConsts.PAY_ITEM.equals(activityType)){
            changeLeftBtn.setText("取消订单");
            changeRightBtn.setText("去支付");
        }
        else if(StringConsts.PAY_AGAIN_ITEM.equals(activityType)){
            changeLeftBtn.setText("评价晒单");
            changeRightBtn.setText("再次购买");
        }
        else if(StringConsts.DRAWBACK_ITEM.equals(activityType)){
            changeLeftBtn.setVisibility(View.INVISIBLE);
            changeRightBtn.setText("退款");
        }



    }
}
