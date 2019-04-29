package com.example.muqier.myapplication.persenter;

import com.example.muqier.myapplication.bean.BeanList;
import com.example.muqier.myapplication.callback.callBack;
import com.example.muqier.myapplication.mainview.MainView;
import com.example.muqier.myapplication.model.MainModel;

public class MainPersentermpl implements MainPersenter, callBack {

     private MainModel mainModel;
     private MainView mainView;

    public MainPersentermpl(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }
    @Override
    public void onSuccess(BeanList beanList) {
        if (mainView!=null){
            mainView.onSuccess(beanList);
        }
    }

    @Override
    public void onFail(String str) {
            if (mainView!=null){
                mainView.onFail(str);
            }
    }

    @Override
    public void getData(String userId, String channelId, String cursor) {
        if (mainModel!=null){
            mainModel.getData(userId,channelId,cursor,this);
        }
    }
}
