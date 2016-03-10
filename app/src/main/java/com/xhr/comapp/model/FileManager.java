package com.xhr.comapp.model;

import com.xhr.comapp.model.file.ScreenImageHelper;

/**
 * Created by xhrong on 2016/3/10.
 */
public class FileManager {

    private static FileManager fileManager;

    private ScreenImageHelper screenImageHelper;

    public static FileManager getInstance(){
        if(fileManager==null){
            fileManager=new FileManager();
        }
        return fileManager;
    }

    private FileManager(){

    }


    public ScreenImageHelper getScreenImageHelper(){
        if(screenImageHelper==null){
            screenImageHelper=new ScreenImageHelper();
        }
        return screenImageHelper;
    }
}
