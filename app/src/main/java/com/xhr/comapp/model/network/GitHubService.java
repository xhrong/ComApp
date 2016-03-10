package com.xhr.comapp.model.network;

import com.xhr.comapp.model.dao.Contributor;
import com.xhr.comapp.model.dao.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by xhrong on 2016/3/8.
 */
public interface GitHubService {

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    @GET("/users/{userName}")
    Observable<UserInfo> user(@Path("userName") String userName);
}

