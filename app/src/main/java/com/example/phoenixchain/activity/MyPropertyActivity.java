package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by Sanji on 2017/6/19.
 */

public class MyPropertyActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_property);
        initTitleAndToolbar(R.id.include_tb_my_property, TitleConsts.MY_PROPERTY_TITLE);
        TextView tv_transaction_record = (TextView) findViewById(R.id.more_transaction);
        tv_transaction_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPropertyActivity.this, TransactionRecordActivity.class);
                startActivity(intent);

            }
        });
    }
}
