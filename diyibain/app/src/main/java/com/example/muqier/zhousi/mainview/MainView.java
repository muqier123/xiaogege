package com.example.muqier.zhousi.mainview;

import com.example.muqier.zhousi.bean.BeanList;

public interface MainView {
    void onSuccess(BeanList beanList);
    void onFail(String str);
}
