package com.starwar.electriccigarette_02;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HorizontalScrollView hsv_china;
    private LinearLayout imageContainer;
    private TextView tv_title;
    private TextView tv_title_china;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initView();

        initRecyclerViewChina();

        initRecyclerViewInport();

    }

    private void initRecyclerViewInport() {

    }

    private void initRecyclerViewChina() {
        RecyclerView recyclerView_china = findViewById(R.id.recyclerView_china);
        // 设置横向布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_china.setLayoutManager(layoutManager);

        // 图片资源
        List<Integer> images = Arrays.asList(
                R.mipmap.image1,
                R.mipmap.image2,
                R.mipmap.image3,
                R.mipmap.image4,
                R.mipmap.image5,
                R.mipmap.image6,
                R.mipmap.image7,
                R.mipmap.image8
        );

        // 设置适配器
        ImageAdapter adapter = new ImageAdapter(this, images);
        recyclerView_china.setAdapter(adapter);
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title_china = (TextView) findViewById(R.id.tv_title_china);
    }
}