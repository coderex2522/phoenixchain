package com.example.phoenixchain.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixchain.R;
import com.example.phoenixchain.TitleConsts;

/**
 * Created by coderex2522 on 6/22/2017.
 */

public class ApplyDrawbackActivity extends BaseActivity implements View.OnClickListener{
    private Button commitApplicationBtn;
    private TextView drawbackMoneyTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_drawback);
        initTitleAndToolbar(R.id.include_tb_apply_drawback, TitleConsts.APPLY_DRAWBACK_TITLE);

        commitApplicationBtn = (Button) findViewById(R.id.btn_commit_application);
        drawbackMoneyTextView = (TextView) findViewById(R.id.tv_drawback_money);

        commitApplicationBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_commit_application:
                showCommitApplicationDialog();
                break;
        }
    }

    private void showCommitApplicationDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("退款申请");
        alertDialogBuilder.setMessage("申请已提交,请稍等");
        alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.show();
    }
}
