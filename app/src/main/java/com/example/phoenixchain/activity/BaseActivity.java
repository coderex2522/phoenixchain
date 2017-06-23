package com.example.phoenixchain.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.phoenixchain.R;

/**
 * Created by coderex2522 on 6/20/2017.
 */

public class BaseActivity extends AppCompatActivity {
    private TextView titleTextView;
    private Toolbar toolbar;
    private int includeToolbarId;

    protected void initTitleAndToolbar(int id,String title){
        includeToolbarId=id;

        //init the widget
        titleTextView = (TextView) findViewById(includeToolbarId).findViewById(R.id.tv_title);
        toolbar = (Toolbar) findViewById(includeToolbarId).findViewById(R.id.tb_base);


        //set the title and toolbar
        titleTextView.setText(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }
}
