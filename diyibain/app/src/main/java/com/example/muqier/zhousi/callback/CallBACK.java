package com.example.muqier.zhousi.callback;

import com.example.muqier.zhousi.bean.BeanList;

public interface CallBACK {
    void onSuccess(BeanList beanList);
    void onFail(String str);

}
