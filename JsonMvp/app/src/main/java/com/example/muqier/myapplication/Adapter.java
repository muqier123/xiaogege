package com.example.muqier.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.muqier.myapplication.bean.BeanList;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHloder> {
    private ArrayList<BeanList.DataBean.NewListBean>list;
    private Context context;

    public Adapter(ArrayList<BeanList.DataBean.NewListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<BeanList.DataBean.NewListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LinearLayout.inflate(context, R.layout.lay, null);
        ViewHloder viewHloder = new ViewHloder(inflate);

        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHloder holder, int position) {
        BeanList.DataBean.NewListBean bean=list.get(position);
        holder.tv1.setText(list.get(position).getTitle());
        holder.tv.setText(list.get(position).getOrigin());
        Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {
        private ImageView im;
        private TextView tv;
        private TextView tv1;
        public ViewHloder(View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im);
            tv=itemView.findViewById(R.id.tv1);
            tv1=itemView.findViewById(R.id.tv2);
        }
    }
}
