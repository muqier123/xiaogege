package com.example.muqier.zhousi.api;

import com.example.muqier.zhousi.bean.BeanList;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyServer {
    public String Url="https://cnodejs.org/api/v1/topics/";
    @POST("page=1&tab=good&limit=10")
    Observable<BeanList> getData();

}
