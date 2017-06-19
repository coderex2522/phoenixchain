package com.example.phoenixchain.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phoenixchain.MainActivity;
import com.example.phoenixchain.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by coderex2522 on 6/5/2017.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    private Toolbar homeToolbar;

    //about pay items
    private List<String> payItemNameList;
    private List<Integer> payItemImgResList;
    private List<Integer> payItemIdList;

    //about application items
    private List<String> applicationItemNameList;
    private List<Integer> applicationItemImgResList;
    private List<Integer> applicationItemIdList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_home,container,false);

        //init the toolbar of the home activity
        homeToolbar = (Toolbar) contentView.findViewById(R.id.include_tb_home)
                .findViewById(R.id.tb_base);
        ((MainActivity)getActivity()).setSupportActionBar(homeToolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        setHasOptionsMenu(true);
        //init pay items
        initPayList(contentView);
        initApplicationList(contentView);

        return contentView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar_home,menu);
    }

    private void initPayList(View parentView) {
        payItemImgResList = new ArrayList<Integer>(
                Arrays.asList(R.mipmap.ic_scancode, R.mipmap.ic_pay_money, R.mipmap.ic_collect, R.mipmap.ic_transfer));
        payItemNameList = new ArrayList<String>(
                Arrays.asList("扫码", "付币", "收币", "转账"));
        payItemIdList = new ArrayList<Integer>(
                Arrays.asList(R.id.include_scancode,R.id.include_pay_money,R.id.include_collect,R.id.include_transfer));
        for(int i=0;i<4;i++){
            View childView = parentView.findViewById(payItemIdList.get(i));
            childView.setOnClickListener(this);
            ImageView childIV = (ImageView) childView.findViewById(R.id.iv_pay_item);
            childIV.setImageResource(payItemImgResList.get(i));
            TextView childTV = (TextView) childView.findViewById(R.id.tv_pay_item);
            childTV.setText(payItemNameList.get(i));
        }
    }

    private void initApplicationList(View parentView){
        applicationItemImgResList = new ArrayList<Integer>(
                Arrays.asList(R.mipmap.ic_shop,R.mipmap.ic_more,R.mipmap.ic_space,R.mipmap.ic_space));
        applicationItemNameList = new ArrayList<String>(
                Arrays.asList("购票","更多", " "," "));
        applicationItemIdList = new ArrayList<Integer>(
                Arrays.asList(R.id.include_shop,R.id.include_more,R.id.include_space1,R.id.include_space2));

        for(int i=0;i<4;i++){
            View childView = parentView.findViewById(applicationItemIdList.get(i));
            ImageView childIV = (ImageView) childView.findViewById(R.id.iv_application_item);
            childIV.setImageResource(applicationItemImgResList.get(i));
            TextView childTV = (TextView) childView.findViewById(R.id.tv_application_item);
            childTV.setText(applicationItemNameList.get(i));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.include_scancode:
                //ImageView scancodeIV = (ImageView) v.findViewById( R.id.iv_pay_item);
                //Drawable scancodeIVDrawable = scancodeIV.getDrawable();
                //scancodeIV.setImageDrawable(UsefulTools.tintDrawable(scancodeIVDrawable, ColorStateList.valueOf(Color.BLACK)));
                break;
            case R.id.include_pay_money:
                break;
            case R.id.include_collect:
                break;
            case R.id.include_transfer:
                //ImageView transferIV = (ImageView) v.findViewById(R.id.iv_pay_item);
                //Drawable transferIVDrawable = transferIV.getDrawable();
                Intent transferIntent = new Intent(v.getContext(),SearchAccountOfTransferActivity.class);
                //transferIV.setImageDrawable(UsefulTools.tintDrawable(transferIVDrawable,ColorStateList.valueOf(Color.DKGRAY)));
                startActivity(transferIntent);
                break;
        }
    }
}
