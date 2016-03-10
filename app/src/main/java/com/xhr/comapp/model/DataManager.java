package com.xhr.comapp.model;

import com.xhr.comapp.config.AppConfig;
import com.xhr.comapp.model.network.GitHubService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xhrong on 2016/3/8.
 */
public class DataManager {

    private static DataManager dataManager;

    public static DataManager getInstance(){
        if(dataManager==null){
            dataManager=new DataManager();
        }
        return dataManager;
    }

    private GitHubService gitHubService;


    private DataManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        gitHubService = retrofit.create(GitHubService.class);
    }

    public GitHubService getGitHubService(){
        return  gitHubService;
    }
}
