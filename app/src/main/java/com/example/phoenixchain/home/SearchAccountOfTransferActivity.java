package com.example.phoenixchain.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixchain.OnItemClickListener;
import com.example.phoenixchain.R;
import com.example.phoenixchain.StringConsts;
import com.example.phoenixchain.TitleConsts;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coderex2522 on 6/9/2017.
 */

public class SearchAccountOfTransferActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher{
    private EditText inputAccountET;
    private Button nextStepBtn;
    private RecyclerView recentContactsRV;
    private RecentContactsRecyclerViewAdapter recentContactsRecyclerViewAdapter;
    private List<RecentContacts> recentContactsList;
    private Toolbar toolbar;
    private TextView titleTextView;
    private RecentContactsRecyclerViewAdapter recentContactsAdapter;


    private void initRecentContactsList(){
        recentContactsList = new ArrayList<RecentContacts>();
        RecentContacts recentContacts0 = new RecentContacts("张鑫",R.mipmap.ic_shop,"13600936539");
        recentContactsList.add(recentContacts0);
        RecentContacts recentContacts1 = new RecentContacts("张鑫1",R.mipmap.ic_shop,"13600916539");
        recentContactsList.add(recentContacts1);
        RecentContacts recentContacts2 = new RecentContacts("张鑫2",R.mipmap.ic_shop,"13600926539");
        recentContactsList.add(recentContacts2);
        RecentContacts recentContacts3 = new RecentContacts("张鑫3",R.mipmap.ic_shop,"13600946539");
        recentContactsList.add(recentContacts3);
        RecentContacts recentContacts4 = new RecentContacts("张鑫",R.mipmap.ic_shop,"13600936539");
        recentContactsList.add(recentContacts4);
        RecentContacts recentContacts5 = new RecentContacts("张鑫1",R.mipmap.ic_shop,"13600916539");
        recentContactsList.add(recentContacts5);
        RecentContacts recentContacts6 = new RecentContacts("张鑫2",R.mipmap.ic_shop,"13600926539");
        recentContactsList.add(recentContacts6);
        RecentContacts recentContacts7 = new RecentContacts("张鑫3",R.mipmap.ic_shop,"13600946539");
        recentContactsList.add(recentContacts7);
        RecentContacts recentContacts8 = new RecentContacts("张鑫",R.mipmap.ic_shop,"13600936539");
        recentContactsList.add(recentContacts8);
        RecentContacts recentContacts9 = new RecentContacts("张鑫1",R.mipmap.ic_shop,"13600916539");
        recentContactsList.add(recentContacts9);
        RecentContacts recentContacts10 = new RecentContacts("张鑫2",R.mipmap.ic_shop,"13600926539");
        recentContactsList.add(recentContacts10);
        RecentContacts recentContacts11 = new RecentContacts("张鑫3",R.mipmap.ic_shop,"13600946539");
        recentContactsList.add(recentContacts11);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_account_transfer);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //init the widget
        toolbar = (Toolbar) findViewById(R.id.include_tb_search_account).findViewById(R.id.tb_base);
        titleTextView = (TextView) findViewById(R.id.include_tb_search_account).findViewById(R.id.tv_title);
        nextStepBtn = (Button) findViewById(R.id.btn_next_step);
        inputAccountET = (EditText) findViewById(R.id.et_input_account);
        recentContactsRV = (RecyclerView) findViewById(R.id.rv_recent);

        //process the edit-text of input account ;
        inputAccountET.addTextChangedListener(this);

        //set the toolbar and the title
        titleTextView.setText(TitleConsts.SEARCH_ACCOUNT_TITLE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        //set the info of RecentContactsRecyclerView;
        initRecentContactsList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recentContactsRV.setLayoutManager(linearLayoutManager);
        recentContactsAdapter = new RecentContactsRecyclerViewAdapter(recentContactsList);
        recentContactsRV.setAdapter(recentContactsAdapter);
        recentContactsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                RecentContacts recentContactsItem = recentContactsList.get(position);
                Intent intent = new Intent(SearchAccountOfTransferActivity.this,TransferStartActivity.class);
                intent.putExtra(StringConsts.RECENT_CONTACTS_ITEM,recentContactsItem);
                startActivity(intent);
            }
        });

        //set the next step button
        nextStepBtn.setOnClickListener(this);
    }

    //hide the soft keyboard;
    public boolean onTouchEvent(MotionEvent event) {
        if(null != this.getCurrentFocus()){
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super .onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        SearchAccountOfTransferActivity.this.finish();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().isEmpty()){
            nextStepBtn.setBackgroundColor(getResources().getColor(R.color.colorBtnGrey,null));
        }
        else{
            nextStepBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary,null));
        }
    }
}
