package com.bawei.huwanjun.view.myadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.huwanjun.R;
import com.bawei.huwanjun.model.bean.Bean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * author: 斛万珺
 * data: 2019/12/25 11:11:21
 * function:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Bean> list=new ArrayList<>();

    public MyAdapter(List<Bean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.item_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView text_name;
        TextView text_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            text_name=itemView.findViewById(R.id.text_name);
            text_price=itemView.findViewById(R.id.text_price);
        }
    }
}
