package com.example.phoenixchain.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.phoenixchain.R;
import com.example.phoenixchain.activity.LoginActivity;
import com.example.phoenixchain.activity.MyPropertyActivity;
import com.example.phoenixchain.activity.SecuritySettingActivity;
import com.example.phoenixchain.activity.SelfInfoActivity;
import com.example.phoenixchain.activity.MyOrdersActivity;

/**
 * Created by coderex2522 on 6/5/2017.
 */

public class MeFragment extends Fragment implements View.OnClickListener{
    private LinearLayout myOrdersLinearLayout;
    private Button btnLogin;
    private LinearLayout llSelfInfo;
    private LinearLayout llProperty;
    private LinearLayout llSecuritySetting;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_me,container,false);

        myOrdersLinearLayout = (LinearLayout) contentView.findViewById(R.id.ll_my_orders);
        btnLogin = (Button) contentView.findViewById(R.id.btn_login);
        llSelfInfo = (LinearLayout) contentView.findViewById(R.id.ll_self_info);
        llProperty = (LinearLayout) contentView.findViewById(R.id.ll_property);
        llSecuritySetting = (LinearLayout) contentView.findViewById(R.id.ll_security_setting);

        myOrdersLinearLayout.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        llSelfInfo.setOnClickListener(this);
        llProperty.setOnClickListener(this);
        llSecuritySetting.setOnClickListener(this);
        return contentView;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.ll_my_orders:
                intent = new Intent(v.getContext(),MyOrdersActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_self_info:
                intent = new Intent(v.getContext(), SelfInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_property:
                intent = new Intent(v.getContext(), MyPropertyActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_security_setting:
                intent = new Intent(v.getContext(), SecuritySettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
