package com.xhr.comapp.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xhr.comapp.R;
import com.xhr.comapp.model.dao.UserInfo;
import com.xhr.comapp.presenter.IMainPresenter;
import com.xhr.comapp.presenter.MainPresenter;
import com.xhr.comapp.util.RxBus.RxBus;
import com.xhr.comapp.util.RxBus.UserEvent;
import com.xhr.comapp.view.base.BaseFragment;
import com.xhr.comapp.view.base.IMainView;

import java.util.Date;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by xhrong on 2016/3/10.
 */
public class MainFragment extends BaseFragment implements IMainView {


    private static String TAG = "MainFragment";

    private IMainPresenter mainPresenter;

    private Subscription rxSubscription = null;


    //三个一般必须重载的方法
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        mainPresenter = new MainPresenter(this);

        mainPresenter.getUser("xhrong");

        rxSubscription = RxBus.getDefault().toObserverable(UserEvent.class)
                .subscribe(new Subscriber<UserEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserEvent userEvent) {
                        Log.e(TAG, userEvent.getName() + userEvent.getId());
                    }
                });

        return view;
    }


    private void initView(final  View view) {
        view.findViewById(R.id.captureScreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.takeViewShot(view, "screenshot_" + new Date().getTime() + ".png");
            }
        });
    }


    @Override
    public void showUser(UserInfo userInfo) {
        if (userInfo != null) {
            Toast.makeText(getActivity(), userInfo.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }
    }
}
