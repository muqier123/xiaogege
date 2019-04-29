package com.example.muqier.zhousi.persenter;

import com.example.muqier.zhousi.bean.BeanList;
import com.example.muqier.zhousi.callback.CallBACK;
import com.example.muqier.zhousi.mainmodel.MainModel;
import com.example.muqier.zhousi.mainview.MainView;

import retrofit2.http.POST;

public class MainPersentermpl implements MainPersenter,CallBACK {
    private MainModel mainModel;
    private MainView mainView;

    public MainPersentermpl(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void onSuccess(BeanList beanList) {
        mainView.onSuccess(beanList);
    }

    @Override
    public void onFail(String str) {
        mainView.onFail(str);
    }

    @Override
    public void getData() {
        mainModel.getData(this);
    }
}
