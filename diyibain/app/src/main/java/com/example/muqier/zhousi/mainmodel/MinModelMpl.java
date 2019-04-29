package com.example.muqier.zhousi.mainmodel;

import com.example.muqier.zhousi.api.MyServer;
import com.example.muqier.zhousi.bean.BeanList;
import com.example.muqier.zhousi.callback.CallBACK;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MinModelMpl implements MainModel{
    @Override
    public void getData(final CallBACK callBACK) {
        Retrofit build = new Retrofit.Builder().baseUrl(MyServer.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = build.create(MyServer.class);

        Observable<BeanList> data = myServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeanList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeanList beanList) {
                       if (beanList.getData()!= null && beanList!= null && beanList.getData().size()>0){
                           callBACK.onSuccess(beanList);
                       }else {
                           callBACK.onFail("失败");
                       }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBACK.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
