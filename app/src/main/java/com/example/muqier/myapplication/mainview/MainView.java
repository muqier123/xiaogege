package com.example.muqier.myapplication.mainview;

import com.example.muqier.myapplication.bean.BeanList;

public interface MainView {
    void onSuccess(BeanList beanList);
    void onFail(String str);
}
