package com.example.muqier.myapplication.callback;

import com.example.muqier.myapplication.bean.BeanList;

public interface CallBack {
    void onSuccess(BeanList beanList);
    void onFail(String str);
}
