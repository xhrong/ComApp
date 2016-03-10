package com.xhr.comapp.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhr.comapp.R;
import com.xhr.comapp.util.RxBus.RxBus;
import com.xhr.comapp.util.RxBus.UserEvent;
import com.xhr.comapp.view.base.BaseActivity;
import com.xhr.comapp.view.base.BaseFragment;
import com.xhr.comapp.view.base.ISubView;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by xhrong on 2016/3/10.
 */
public class SubFragment extends BaseFragment implements ISubView {

    private static String TAG = "SubActivity";

    private Subscription rxSubscription = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_sub, container, false);


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


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }
    }
}
