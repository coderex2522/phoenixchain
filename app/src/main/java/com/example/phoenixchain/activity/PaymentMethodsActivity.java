package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by coderex2522 on 6/21/2017.
 */

public class PaymentMethodsActivity extends BaseActivity implements View.OnClickListener{
    private static final int PAY_METHODS_CNT = 3;
    private RadioButton payMethodsRB[] = new RadioButton[PAY_METHODS_CNT];
    private int payMethodsRBId[] = new int[]{R.id.rb_phoenix,R.id.rb_wechat,R.id.rb_alipay};
    private RelativeLayout payMethodsRL[] = new RelativeLayout[PAY_METHODS_CNT];
    private int payMethodsRLId[]=new int[]{R.id.rl_phoenix,R.id.rl_wechat,R.id.rl_alipay};
    private Button requirePayBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_methods);
        initTitleAndToolbar(R.id.include_tb_payment_methods, TitleConsts.PAYMENT_METHODS_TITLE);

        requirePayBtn = (Button) findViewById(R.id.btn_pm_require_pay);
        for(int i=0;i<3;i++)
        {
            payMethodsRB[i] = (RadioButton) findViewById(payMethodsRBId[i]);
            payMethodsRB[i].setOnClickListener(this);
            payMethodsRL[i] = (RelativeLayout) findViewById(payMethodsRLId[i]);
            payMethodsRL[i].setOnClickListener(this);
        }

        //set the button of require pay
        requirePayBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_phoenix:
            case R.id.rl_phoenix:
                setTheOneOfPayMethodsChecked(0);
                break;
            case R.id.rb_wechat:
            case R.id.rl_wechat:
                setTheOneOfPayMethodsChecked(1);
                break;
            case R.id.rb_alipay:
            case R.id.rl_alipay:
                setTheOneOfPayMethodsChecked(2);
                break;
            case R.id.btn_pm_require_pay:
                Intent intent = new Intent(PaymentMethodsActivity.this,PaySuccessActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void setTheOneOfPayMethodsChecked(int x){
        for(int i=0;i<PAY_METHODS_CNT;i++){
            if (i != x){
                payMethodsRB[i].setChecked(false);
            }
            else
                payMethodsRB[i].setChecked(true);
        }
    }
}
