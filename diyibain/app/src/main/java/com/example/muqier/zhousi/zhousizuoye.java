package com.example.muqier.zhousi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.muqier.zhousi.bean.BeanList;
import com.example.muqier.zhousi.mainmodel.MinModelMpl;
import com.example.muqier.zhousi.mainview.MainView;
import com.example.muqier.zhousi.persenter.MainPersenter;
import com.example.muqier.zhousi.persenter.MainPersentermpl;

import java.util.ArrayList;
import java.util.List;

public class zhousizuoye extends AppCompatActivity implements MainView {

    private RecyclerView mRl;
    private ArrayList<BeanList.DataBean>list;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhousizuoye);
        initView();
        initData();

    }

    private void initData() {
        MainPersenter mainPersenter=new MainPersentermpl(new MinModelMpl(),this);
        mainPersenter.getData();
    }

    private void initView() {
        mRl = (RecyclerView) findViewById(R.id.rl);



        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRl.setLayoutManager(manager);
        list=new ArrayList<>();
        adapter = new Adapter(list, this);
        mRl.setAdapter(adapter);


    }

    @Override
    public void onSuccess(BeanList beanList) {
        List<BeanList.DataBean> data = beanList.getData();
        list.addAll(data);
       adapter.setList(list);
       adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String str) {

    }
}
