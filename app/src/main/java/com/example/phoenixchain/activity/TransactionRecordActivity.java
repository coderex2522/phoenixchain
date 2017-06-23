package com.example.phoenixchain.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;
import com.example.phoenixchain.adapter.MyAdapter;
import com.example.phoenixchain.bean.TransactionInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sanji on 2017/6/19.
 */

public class TransactionRecordActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;
    //private String[] data =new String[]{"2017/6/18","2017/6/19","2017/6/20","?????","2017/6/18","2017/6/19","2017/6/20","?????","2017/6/18","2017/6/19","2017/6/20","?????"};

    private List<TransactionInfo> transactionInfos = new ArrayList<>();



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_record);
        initTitleAndToolbar(R.id.include_tb_transaction_record, TitleConsts.TRANSACTION_RECORD_TITLE);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);

        Date date = new Date();
        //String dateStr = "2010-9-10";
        //String[] dateDivide=dateStr.split("-");
        //int year=Integer.parseInt(dateDivide[0].trim());//去掉空格  
        //int month=Integer.parseInt(dateDivide[1].trim());
        //int day=Integer.parseInt(dateDivide[2].trim());
        TransactionInfo transactionInfo1 = new TransactionInfo(date,9,"快了的大","-转账");
        TransactionInfo transactionInfo2 = new TransactionInfo(date,10,"快了的大1","-转账2");
        TransactionInfo transactionInfo3 = new TransactionInfo(date,11,"快了的大2","-转账3");
        TransactionInfo transactionInfo4 = new TransactionInfo(date,12,"快了的大3","-转账4");
        TransactionInfo transactionInfo5 = new TransactionInfo(date,13,"快了的大4","-转账5");
        TransactionInfo transactionInfo6 = new TransactionInfo(date,14,"快了的大5","-转账6");
        TransactionInfo transactionInfo7 = new TransactionInfo(date,15,"快了的大6","-转账7");
        TransactionInfo transactionInfo8 = new TransactionInfo(date,16,"快了的大7","-转账8");
        TransactionInfo transactionInfo9 = new TransactionInfo(date,17,"快了的大8","-转账9");
        TransactionInfo transactionInfo10 = new TransactionInfo(date,18,"快了的大9","-转账10");
        transactionInfos.add(transactionInfo1);
        transactionInfos.add(transactionInfo2);
        transactionInfos.add(transactionInfo3);
        transactionInfos.add(transactionInfo4);
        transactionInfos.add(transactionInfo5);
        transactionInfos.add(transactionInfo6);
        transactionInfos.add(transactionInfo7);
        transactionInfos.add(transactionInfo8);
        transactionInfos.add(transactionInfo9);
        transactionInfos.add(transactionInfo10);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(transactionInfos);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(TransactionRecordActivity.this, transactionInfos.get(position).getData().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
