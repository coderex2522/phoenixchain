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
 * Created by Sanji on 2017/6/21.
 */

public class ModifyLoginPassword extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_login_password);
        initTitleAndToolbar(R.id.include_tb_modify_login_password, TitleConsts.MODIFY_LOGIN_PASSWORD_TITLE);
        TextView tvForgetLoginPassword = (TextView) findViewById(R.id.tv_forget_password);
        Button btnConfirmModifyLoginPassword = (Button) findViewById(R.id.btn_confirm_modify_login_password);

        tvForgetLoginPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifyLoginPassword.this, ForgetLoginPasswordActivity.class);
                startActivity(intent);
            }
        });

        btnConfirmModifyLoginPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifyLoginPassword.this, SetNewLoginPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}
