package com.xhr.comapp.presenter;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by xhrong on 2016/3/10.
 */
public interface IMainPresenter {

    public void getUser(String userName);

    public void takeViewShot(View view, String imageName);

}
