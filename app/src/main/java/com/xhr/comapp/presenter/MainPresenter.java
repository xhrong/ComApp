package com.xhr.comapp.presenter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import com.xhr.comapp.util.RxBus.RxBus;
import com.xhr.comapp.util.RxBus.UserEvent;
import com.xhr.comapp.model.DataManager;
import com.xhr.comapp.model.FileManager;
import com.xhr.comapp.model.dao.UserInfo;
import com.xhr.comapp.view.base.IMainView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xhrong on 2016/3/10.
 */
public class MainPresenter implements IMainPresenter {

    private static String TAG = "MainPresenter";

    private IMainView mainView;

    public MainPresenter(IMainView mainView) {
        this.mainView = mainView;
    }


    public void takeViewShot(View view, String imageName) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();

        // 获取状态栏高度
        Rect frame = new Rect();
        view.getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Log.i("TAG", "" + statusBarHeight);

        // 获取屏幕长和高
        int width = view.getWidth();
        int height = view.getHeight();
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        FileManager.getInstance().getScreenImageHelper().saveScreen(b, imageName);
    }

    @Override
    public void getUser(final String userName) {
        DataManager.getInstance().getGitHubService().user(userName)
                .map(new Func1<UserInfo, UserInfo>() {
                    @Override
                    public UserInfo call(UserInfo userInfo) {
                        userInfo.setName(userInfo.getName().toUpperCase());
                        return userInfo;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserInfo>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                        mainView.showUser(null);
                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        Log.e(TAG, "onNext");
                        mainView.showUser(userInfo);
                        RxBus.getDefault().post(new UserEvent(userInfo.getId(), userInfo.getName()));
                    }
                });
    }
}
