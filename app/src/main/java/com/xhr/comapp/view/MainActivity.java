package com.xhr.comapp.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xhr.comapp.R;
import com.xhr.comapp.model.dao.UserInfo;
import com.xhr.comapp.presenter.IMainPresenter;
import com.xhr.comapp.presenter.MainPresenter;

import com.xhr.comapp.util.RxBus.RxBus;
import com.xhr.comapp.util.RxBus.UserEvent;
import com.xhr.comapp.view.base.BaseActivity;
import com.xhr.comapp.view.base.IMainView;
import com.xhr.comapp.view.fragment.MainFragment;
import com.xhr.comapp.view.fragment.SubFragment;

import java.util.Date;

import rx.Subscriber;
import rx.Subscription;


public class MainActivity extends BaseActivity{

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //在程序中加入Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = new MainFragment();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();

        initView();
    }

    private void initView(){
        findViewById(R.id.main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在程序中加入Fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment fragment = new MainFragment();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });

        findViewById(R.id.sub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在程序中加入Fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment fragment = new SubFragment();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });
    }
}
