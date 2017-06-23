package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by Sanji on 2017/6/21.
 */

public class SecuritySettingActivity extends BaseActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_setting);
        initTitleAndToolbar(R.id.include_tb_security_setting, TitleConsts.SECURITY_SETTING_TITLE);
        RelativeLayout rlModifyLoginPassword = (RelativeLayout) findViewById(R.id.rl_modify_login_password);
        RelativeLayout rlBackupPrivateKey = (RelativeLayout) findViewById(R.id.rl_backup_private_key);
        RelativeLayout rlRestorePrivateKey = (RelativeLayout) findViewById(R.id.rl_restore_private_key);
        RelativeLayout rlSetPaymentPassword = (RelativeLayout) findViewById(R.id.rl_set_payment_password);

        rlModifyLoginPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecuritySettingActivity.this, ModifyLoginPassword.class);
                startActivity(intent);
            }
        });

        rlBackupPrivateKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecuritySettingActivity.this, SetPrivateKeyPassword.class);
                startActivity(intent);
            }
        });

        rlRestorePrivateKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecuritySettingActivity.this, RestorePrivateKey.class);
                startActivity(intent);

            }
        });

        rlSetPaymentPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecuritySettingActivity.this, SetPaymentPassword.class);
                startActivity(intent);
            }
        });
    }
}
