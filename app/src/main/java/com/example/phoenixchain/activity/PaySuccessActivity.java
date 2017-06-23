package com.example.phoenixchain.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by coderex2522 on 6/22/2017.
 */

public class PaySuccessActivity extends BaseActivity implements View.OnClickListener{
    private Button doneBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_success);
        initTitleAndToolbar(R.id.include_tb_pay_success, TitleConsts.PAY_SUCCESS_TITLE);

        doneBtn = (Button) findViewById(R.id.btn_ps_done);

        doneBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.finish();
    }
}
