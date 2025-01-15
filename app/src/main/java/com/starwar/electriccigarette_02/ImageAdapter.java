package com.starwar.electriccigarette_02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {


    private Context context;
    private List<Integer> imageList;

    //构造方法
    public ImageAdapter(Context context , List<Integer> imageList){
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    //创建ViewHolder
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    //数据绑定
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(imageList.get(position));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, CigaretteSmoke.class);
                context.startActivity(intent);
            }
        });
    }

    //获取列表项数量，RecyclerView 根据此数量创建对应数量的列表项。
    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            //初始化控件
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
