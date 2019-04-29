package com.example.muqier.myapplication.model;

import com.example.muqier.myapplication.api.MyServer;
import com.example.muqier.myapplication.bean.BeanList;
import com.example.muqier.myapplication.callback.callBack;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.chrono.MinguoChronology;

import javax.security.auth.callback.Callback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModelmpl implements MainModel
{
    @Override
    public void getData(String userId, String channelId, String cursor, final callBack callback) {
        Retrofit retrofit = new Retrofit.Builder().
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.url)
                .build();

        MyServer myServer = retrofit.create(MyServer.class);

        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("userId","d56ea66e7ee741f498ca51242c8c6394");
            jsonObject.put("channelId","b9240eee3b0211e8b64c00163e30445d");
            jsonObject.put("cursor","0");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaType parse = MediaType.parse("application/json,charset=utf-8");
        String s = jsonObject.toString();

        RequestBody body = RequestBody.create(parse, s);

        Observable<BeanList> data = myServer.getData(body);

        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeanList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeanList beanList) {
                        if (beanList!=null){
                            if (beanList.getCode()==0){
                                callback.onSuccess(beanList);
                            }else {
                                callback.onFail(beanList.getMessage());
                            }
                        }else {
                            callback.onFail("错误");

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
