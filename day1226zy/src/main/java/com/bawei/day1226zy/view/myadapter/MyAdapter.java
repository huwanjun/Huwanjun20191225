package com.bawei.day1226zy.view.myadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.day1226zy.R;
import com.bawei.day1226zy.model.bean.Bean;
import com.bawei.day1226zy.util.NetUtil;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author: 斛万珺
 * data: 2019/12/26 20:20:21
 * function:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bean.ResultBean> result;

    public MyAdapter(List<Bean.ResultBean> result) {

        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.item_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Bean.ResultBean resultBean = result.get(i);
        myViewHolder.text_name.setText(resultBean.getCommodityName());
        NetUtil.getInstance().getPhoto(resultBean.getMasterPic(),myViewHolder.img);


    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView text_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            text_name=itemView.findViewById(R.id.text_name);
        }
    }
}
