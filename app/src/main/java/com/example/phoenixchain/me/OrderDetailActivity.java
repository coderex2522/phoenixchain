package com.example.phoenixchain.me;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.phoenixchain.ChildActivity;
import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by coderex2522 on 6/21/2017.
 */

public class OrderDetailActivity extends ChildActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initTitleAndToolbar(R.id.include_tb_order_detail, TitleConsts.ORDER_DETAIL_TITLE);
    }
}
