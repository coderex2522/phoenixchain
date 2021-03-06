package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by Sanji on 2017/6/22.
 */

public class SetNewPaymentPassword extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_payment_password);
        initTitleAndToolbar(R.id.include_tb_set_new_payment_password, TitleConsts.SET_NEW_PAYMENT_PASSWORD_TITLE);

        Button btnModifyPaymentPassword = (Button) findViewById(R.id.btn_confirm_modify_payment_password);
        btnModifyPaymentPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetNewPaymentPassword.this, com.example.phoenixchain.activity.SecuritySettingActivity.class);
                startActivity(intent);
            }
        });


    }
}
