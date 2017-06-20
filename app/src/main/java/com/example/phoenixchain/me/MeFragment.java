package com.example.phoenixchain.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.phoenixchain.R;

/**
 * Created by coderex2522 on 6/5/2017.
 */

public class MeFragment extends Fragment implements View.OnClickListener{
    private LinearLayout myOrdersLinearLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_me,container,false);
        myOrdersLinearLayout = (LinearLayout) contentView.findViewById(R.id.ll_my_orders);
        myOrdersLinearLayout.setOnClickListener(this);
        return contentView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_my_orders:
                Intent intent = new Intent(v.getContext(),MyOrdersActivity.class);
                startActivity(intent);
                break;
        }
    }
}
