package com.xhr.comapp.util.RxBus;

/**
 * Created by xhrong on 2016/3/10.
 */
public class UserEvent {
    long id;
    String name;
    public UserEvent(long id,String name) {
        this.id= id;
        this.name= name;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}