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

public class RestorePrivateKey extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restore_private_key);
        initTitleAndToolbar(R.id.include_tb_restore_private_key, TitleConsts.BACKUP_PRIVATE_KEY_TITLE);
        Button btnConfirmRestorePrivateKey = (Button) findViewById(R.id.btn_confirm_restore_private_key);
        btnConfirmRestorePrivateKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestorePrivateKey.this, com.example.phoenixchain.activity.SecuritySettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
