package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.phoenixchain.R;

/**
 * Created by Sanji on 2017/6/21.
 */

public class ForgetLoginPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_login_password);


        Button btnVerify = (Button) findViewById(R.id.btn_verify);
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetLoginPasswordActivity.this, SetNewLoginPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}
