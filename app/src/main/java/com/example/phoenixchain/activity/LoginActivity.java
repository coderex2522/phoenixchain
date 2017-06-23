package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.phoenixchain.MainActivity;
import com.example.phoenixchain.R;

public class LoginActivity extends AppCompatActivity {

    //TextView  LoginTitle= (TextView) findViewById(R.id.tv_login);


    //Toolbar LoginToolbar= (Toolbar) findViewById(R.id.tb_login);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnRegister = (Button) findViewById(R.id.btn_register);
        Button btnForgetLoginPassword = (Button) findViewById(R.id.btn_forget_login_password);
        Button btnLogin = (Button) findViewById(R.id.btn_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                //LoginTitle.setText("注册");
                //setSupportActionBar(LoginToolbar);
            }
        }
        );

        btnForgetLoginPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetLoginAcitivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
