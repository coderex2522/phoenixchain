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
 * Created by Sanji on 2017/6/20.
 */

public class ModifySelfInfoActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_self_info);
        initTitleAndToolbar(R.id.include_tb_modify_self_info, TitleConsts.MODIFY_SELF_INFO_TITLE);
        RelativeLayout rlModifySelfInfo = (RelativeLayout) findViewById(R.id.rl_modify_self_info);
        rlModifySelfInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifySelfInfoActivity.this, SelfInfoActivity.class);
                startActivity(intent);
            }
        });


    }
}
