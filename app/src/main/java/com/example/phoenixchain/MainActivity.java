package com.example.phoenixchain;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MainFragmentSingleton mainFragmentSingleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragmentSingleton = new MainFragmentSingleton();
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        replaceMainFragment(mainFragmentSingleton.getHomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        replaceMainFragment(mainFragmentSingleton.getHomeFragment());
                        break;
                    case R.id.action_trade:
                        replaceMainFragment(mainFragmentSingleton.getTradeFragment());
                        break;
                    case R.id.action_service:
                        replaceMainFragment(mainFragmentSingleton.getServiceFragment());
                       break;
                    case R.id.action_me:
                        replaceMainFragment(mainFragmentSingleton.getMeFragment());
                        break;
                }
                return true;
            }
        });

    }


    private void replaceMainFragment(Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,fragment);
        fragmentTransaction.commit();
    }
}
