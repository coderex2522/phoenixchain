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
 * Created by Sanji on 2017/6/21.
 */

public class SetNewLoginPasswordActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_login_password);
        initTitleAndToolbar(R.id.include_tb_set_new_login_password, TitleConsts.SET_NEW_LOGIN_PASSWORD_TITLE);

        Button btnConfirmNewLoginPassword = (Button) findViewById(R.id.btn_confirm_modify_login_password);
        btnConfirmNewLoginPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetNewLoginPasswordActivity.this, com.example.phoenixchain.activity.SecuritySettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
