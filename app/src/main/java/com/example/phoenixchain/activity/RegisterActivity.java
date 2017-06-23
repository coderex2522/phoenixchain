package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.phoenixchain.R;

public class RegisterActivity extends AppCompatActivity {


    //EditText phoneView= (EditText) findViewById(R.id.phone_number);
    //EditText passwordView= (EditText) findViewById(R.id.password);
    //Subscription subscription



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        /*Button btn1= (Button) findViewById(R.id.btn_register);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = phoneView.getText().toString();
                String password=passwordView.getText().toString();
                if (!phonenumber.isEmpty()&&!password.isEmpty()){
                    //registerUser(phonenumber,password);
                }
                else {
                    Toast.makeText(getApplicationContext(),"请输入手机号和密码",Toast.LENGTH_SHORT).show();


                }

            }
        });*/
    }
    /*private void registerUser(String phonenumber,String password){
        //showLoadingView();

        Call<RegisterInfo> call = RegisterService.getResult(phonenumber);
        call.enqueue(new Callback<RegisterInfo>() {
            @Override
            public void onResponse(Call<RegisterInfo> call, Response<RegisterInfo> response) {

            }

            @Override
            public void onFailure(Call<RegisterInfo> call, Throwable t) {

            }
        });



    }*/


}
