package com.example.muqier.myapplication.persenter;

import com.example.muqier.myapplication.bean.BeanList;
import com.example.muqier.myapplication.callback.CallBack;
import com.example.muqier.myapplication.mainview.MainView;
import com.example.muqier.myapplication.model.MainModel;

public class MainPersentermpl implements MainPersenter,CallBack {
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
