package com.example.phoenixchain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.phoenixchain.R;
import com.example.phoenixchain.StringConsts;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by coderex2522 on 6/19/2017.
 */

public class TransferDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button transferDoneBtn;
    private TextView transferInfoTextView;
    private TextView moneyTextView;
    private TextView titleTextView;
    private Intent getInfoIntent;
    private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_details);
        getInfoIntent = getIntent();

        //init the widget
        transferDoneBtn = (Button) findViewById(R.id.btn_transfer_done);
        transferInfoTextView = (TextView) findViewById(R.id.tv_transfer_info);
        moneyTextView = (TextView) findViewById(R.id.tv_transfer_money);
        toolbar = (Toolbar) findViewById(R.id.include_tb_transfer_details).findViewById(R.id.tb_base);
        titleTextView = (TextView) findViewById(R.id.include_tb_transfer_details).findViewById(R.id.tv_title);

        //init the toolbar and title
        titleTextView.setText(TitleConsts.TRANSFER_DETAILS_TITLE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        //set the transfer info textview
        StringBuilder transferInfoStrBuilder = new StringBuilder();
        transferInfoStrBuilder.append(getInfoIntent.getStringExtra(StringConsts.TRANSFER_DETAILS_NAME));
        transferInfoStrBuilder.append(StringConsts.TRANSFER_DETAILS_INFO);
        transferInfoTextView.setText(transferInfoStrBuilder.toString());

        //set the transfer money textview
        StringBuilder transferMoneyStrBuilder = new StringBuilder();
        transferMoneyStrBuilder.append(String.valueOf(getInfoIntent.getDoubleExtra(StringConsts.TRANSFER_DETAILS_MONEY,0.0)));
        transferMoneyStrBuilder.append(StringConsts.MONEY);
        moneyTextView.setText(transferMoneyStrBuilder.toString());

        //set the button click event
        transferDoneBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TransferDetailsActivity.this.finish();
    }
}
