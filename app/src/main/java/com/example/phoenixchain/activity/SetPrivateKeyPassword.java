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

public class SetPrivateKeyPassword extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_private_key_password);
        initTitleAndToolbar(R.id.include_tb_set_private_password, TitleConsts.SET_PRIVATE_KEY_TITLE);

        Button btnConfirmSetPrivateKeyPassword = (Button) findViewById(R.id.btn_confirm_set_private_key_password);
        btnConfirmSetPrivateKeyPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetPrivateKeyPassword.this, BackupPrivateKey.class);
                startActivity(intent);
            }
        });
    }
}
