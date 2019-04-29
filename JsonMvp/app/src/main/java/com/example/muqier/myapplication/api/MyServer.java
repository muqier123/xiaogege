package com.example.muqier.myapplication.api;

import com.example.muqier.myapplication.bean.BeanList;

;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MyServer {
 /*   https://www.firstgainfo.com/firstga/app/news/downListNews
    POST方式：有参
    请求头设置：
    Content-Type:application/json
    请求体JSON形式：
    {
        "userId": "d56ea66e7ee741f498ca51242c8c6394",
            "channelId": "b9240eee3b0211e8b64c00163e30445d",
            "cursor": "0",
    }*/

    public String url="https://www.firstgainfo.com/firstga/app/";
    @POST("news/downListNews")
    @Headers("Content-Type:application/json")
    Observable<BeanList> getData(@Body RequestBody body);

}
