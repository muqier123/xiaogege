package com.example.muqier.zhousi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.muqier.zhousi.bean.BeanList;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHloder> {
    private ArrayList<BeanList.DataBean>list;
    private Context context;

    public Adapter(ArrayList<BeanList.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<BeanList.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.ViewHloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LinearLayout.inflate(context, R.layout.layout_item, null);
        ViewHloder viewHloder = new ViewHloder(inflate);

        return viewHloder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHloder holder, int position) {
            holder.tv2.setText(list.get(position).getTitle());
     //   Glide.with(context).load(list.get(position).getAvatar_url()).into(holder.im);
          Glide.with(context).load(list.get(position).getAuthor().getAvatar_url()).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHloder extends RecyclerView.ViewHolder {

        private TextView tv2;
            private ImageView im;
        public ViewHloder(View itemView) {
            super(itemView);
          im=itemView.findViewById(R.id.im_item);

            tv2=itemView.findViewById(R.id.tv2);
        }
    }
}
