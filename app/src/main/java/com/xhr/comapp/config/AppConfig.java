package com.xhr.comapp.config;

import android.os.Environment;

/**
 * Created by xhrong on 2016/3/8.
 */
public class AppConfig {

    public static String Base_URL="https://api.github.com";



    public static String GET_USER_URL="https://api.github.com/users/xhrong";

    public static String GET_USER_REPOS="https://api.github.com/users/xhrong/repos";


    public static String SCREEN_SHOT_SAVE_PATH= Environment.getExternalStorageDirectory()+"/screenshot/";
}
