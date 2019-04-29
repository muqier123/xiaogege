package com.example.muqier.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.muqier.myapplication.bean.BeanList;
import com.example.muqier.myapplication.mainview.MainView;
import com.example.muqier.myapplication.model.MainModelmpl;
import com.example.muqier.myapplication.persenter.MainPersenter;
import com.example.muqier.myapplication.persenter.MainPersentermpl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class JSON extends AppCompatActivity implements MainView {
/* "userId": "d56ea66e7ee741f498ca51242c8c6394",
         "channelId": "b9240eee3b0211e8b64c00163e30445d",
         "cursor": "0",*/
    private XRecyclerView mXrl;
    private String userId="d56ea66e7ee741f498ca51242c8c6394";
    private String channelId="b9240eee3b0211e8b64c00163e30445d";
    private String cursor="0";
    private ArrayList<BeanList.DataBean.NewListBean>list;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        initView();
        initData();
    }

    private void initData() {
        MainPersenter mainPersenter=new MainPersentermpl(new MainModelmpl(),this);
        mainPersenter.getData(userId,channelId,cursor);
    }

    private void initView() {
        mXrl = (XRecyclerView) findViewById(R.id.xrl);
        list=new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mXrl.setLayoutManager(manager);
        adapter = new Adapter(list, this);
        mXrl.setAdapter(adapter);
    }

    @Override
    public void onSuccess(BeanList beanList) {
        List<BeanList.DataBean.NewListBean> list1 = beanList.getData().getNewList();
        list.addAll(list1);
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String str) {

    }
}
