package com.example.muqier.myapplication.callback;

import com.example.muqier.myapplication.bean.BeanList;

public interface callBack {

        void onSuccess(BeanList beanList);
        void onFail(String str);
}
