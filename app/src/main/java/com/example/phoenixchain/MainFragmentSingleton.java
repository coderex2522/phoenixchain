package com.example.phoenixchain;

import com.example.phoenixchain.home.HomeFragment;
import com.example.phoenixchain.me.MeFragment;
import com.example.phoenixchain.service.ServiceFragment;
import com.example.phoenixchain.trade.TradeFragment;

/**
 * Created by coderex2522 on 6/5/2017.
 */

public class MainFragmentSingleton {
    private HomeFragment homeFragment;
    private TradeFragment tradeFragment;
    private ServiceFragment serviceFragment;
    private MeFragment meFragment;

    public MainFragmentSingleton() {
        homeFragment = null;
        tradeFragment = null;
        serviceFragment = null;
        meFragment = null;

    }

    public HomeFragment getHomeFragment() {
        if(homeFragment == null)
            homeFragment = new HomeFragment();
        return homeFragment;
    }

    public TradeFragment getTradeFragment() {
        if(tradeFragment == null)
            tradeFragment = new TradeFragment();
        return tradeFragment;
    }

    public ServiceFragment getServiceFragment() {
        if(serviceFragment == null)
            serviceFragment = new ServiceFragment();
        return serviceFragment;
    }

    public MeFragment getMeFragment() {
        if(meFragment == null)
            meFragment = new MeFragment();
        return meFragment;
    }
}
