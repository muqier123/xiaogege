package com.example.muqier.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.muqier.myapplication.api.MyServer;
import com.example.muqier.myapplication.bean.BeanList;
import com.example.muqier.myapplication.mainview.MainView;
import com.example.muqier.myapplication.model.MainModelmpl;
import com.example.muqier.myapplication.persenter.MainPersenter;
import com.example.muqier.myapplication.persenter.MainPersentermpl;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainView {

    private Button mByn;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mByn = (Button) findViewById(R.id.byn);
        mByn.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.byn:
                initData();

                break;
        }
    }

    private void initData() {
        MainPersenter mainPersenter=new MainPersentermpl(new MainModelmpl(),this);
        mainPersenter.getData();

    }

    @Override
    public void onSuccess(BeanList beanList) {
        mTv.setText(beanList.toString());
    }

    @Override
    public void onFail(String str) {
        mTv.setText(str);
    }
}
