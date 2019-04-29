package com.example.muqier.myapplication.model;


import com.example.muqier.myapplication.callback.callBack;

public interface MainModel {
    void getData(String userId,String channelId,String cursor ,callBack callback);
}
