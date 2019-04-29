package com.example.muqier.myapplication.api;

import com.example.muqier.myapplication.bean.BeanList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    public String Url="http://www.wanandroid.com/article/list/";
    @GET("0/json")
    Observable<BeanList> getData();
}
