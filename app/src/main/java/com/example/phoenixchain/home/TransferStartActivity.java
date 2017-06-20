package com.example.phoenixchain.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixchain.R;
import com.example.phoenixchain.StringConsts;
import com.example.phoenixchain.TitleConsts;
import com.example.phoenixchain.UsefulTools;

/**
 * Created by coderex2522 on 6/19/2017.
 */

public class TransferStartActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {
    private Toolbar toolbar;
    private TextView titleTextView;
    private Intent getInfoIntent;
    private RecentContacts recentContactsItem;
    private TextView nameTextView;
    private TextView phoneTextView;
    private EditText transferMoneyEditText;
    private Button confirmTransferBtn;
    private String moneyStr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_start);
        getInfoIntent = getIntent();

        recentContactsItem = (RecentContacts) getInfoIntent.getSerializableExtra(StringConsts.RECENT_CONTACTS_ITEM);

        //init the widget
        titleTextView = (TextView) findViewById(R.id.include_tb_transfer_start).findViewById(R.id.tv_title);
        toolbar = (Toolbar) findViewById(R.id.include_tb_transfer_start).findViewById(R.id.tb_base);
        nameTextView = (TextView) findViewById(R.id.tv_ts_name);
        phoneTextView = (TextView) findViewById(R.id.tv_ts_phone);
        transferMoneyEditText = (EditText) findViewById(R.id.et_transfer_money);
        confirmTransferBtn = (Button) findViewById(R.id.btn_confirm_transfer);

        //init the toolbar and title
        titleTextView.setText(TitleConsts.SEARCH_ACCOUNT_TITLE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        //set the name and phone textview
        nameTextView.setText(recentContactsItem.getName());
        phoneTextView.setText(recentContactsItem.getPhoneNum());

        /*
         * set the confirm transfer button
         */
        //when the edittext of transfer money is empty,set the button of confirm transfer is unable;
        confirmTransferBtn.setEnabled(false);
        confirmTransferBtn.setOnClickListener(this);

        //set the transfer money edittext
        transferMoneyEditText.addTextChangedListener(this);
        //set the edittext only input the number and point
        transferMoneyEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_confirm_transfer){
            String transferMoneyStr = transferMoneyEditText.getText().toString();
            if(!transferMoneyStr.isEmpty()){
                try {
                    Double transferMoney = Double.valueOf(transferMoneyStr);
                    Intent intent = new Intent(TransferStartActivity.this,TransferDetailsActivity.class);
                    intent.putExtra(StringConsts.TRANSFER_DETAILS_NAME,recentContactsItem.getName());
                    intent.putExtra(StringConsts.TRANSFER_DETAILS_MONEY,transferMoney);
                    startActivity(intent);
                    TransferStartActivity.this.finish();
                }
                catch (NumberFormatException numberFormatException){
                    Toast.makeText(TransferStartActivity.this,"输入的金额格式有误",Toast.LENGTH_SHORT).show();
                }
            }
            else
                v.setEnabled(false);

        }
        else
            TransferStartActivity.this.finish();

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        moneyStr = s.toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.d("after",s.toString());
        if (s.toString().isEmpty()){
            confirmTransferBtn.setEnabled(false);
            confirmTransferBtn.setBackgroundColor(getResources().getColor(R.color.colorBtnGrey,null));
        }
        else{
            confirmTransferBtn.setEnabled(true);
            confirmTransferBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary,null));
        }
    }


}
