package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by Sanji on 2017/6/22.
 */

public class ModifyPaymentPassword extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_payment_password);
        initTitleAndToolbar(R.id.include_tb_modify_payment_password, TitleConsts.MODIFY_PAYMENT_PASSWORD_TITLE);
        Button btnConfirmModifyPaymentPassword = (Button) findViewById(R.id.btn_confirm_modify_payment_password);
        TextView tvForgetPaymentPassword = (TextView) findViewById(R.id.tv_forget_payment_password);

        btnConfirmModifyPaymentPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifyPaymentPassword.this, SetNewPaymentPassword.class);
                startActivity(intent);
            }
        });

        tvForgetPaymentPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifyPaymentPassword.this, ForgetPaymentPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}
