package com.starwar.electriccigarette_02;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CigaretteSmoke extends AppCompatActivity {

    private ImageView iv_cigarette_yellow_part;
    private ImageView iv_cigarette_white_part;


    private  int cigarette_numb = 10;


    private int [] images = {
            R.mipmap.ciga_100,
            R.mipmap.ciga_75,
            R.mipmap.ciga_50,
            R.mipmap.ciga_25
    };

    private int currentIndex = 0;
    private ExtendedFloatingActionButton flbtn_cigarette;
    private ExtendedFloatingActionButton flbtn_cigarette_refresh;
    private TextView tv_cigarette_numb;
    private Button btn_confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cigarette_smoke);


        initView();

    }

    private void initView() {
        iv_cigarette_white_part = (ImageView) findViewById(R.id.iv_cigarette_white_part);
        iv_cigarette_yellow_part = (ImageView) findViewById(R.id.iv_cigarette_yellow_part);
        flbtn_cigarette = (ExtendedFloatingActionButton) findViewById(R.id.flbtn_cigarette);
        flbtn_cigarette_refresh = (ExtendedFloatingActionButton) findViewById(R.id.flbtn_cigarette_refresh);
        tv_cigarette_numb = (TextView) findViewById(R.id.tv_cigarette_numb);

        tv_cigarette_numb.setText(String.valueOf(cigarette_numb));
    }


    public void extra(View view) {
        currentIndex = 0;
        iv_cigarette_white_part.setImageResource(images[0]);


        if (  cigarette_numb > 1){
            String current_numb = tv_cigarette_numb.getText().toString().trim();
            tv_cigarette_numb.setText(String.valueOf(Integer.parseInt(current_numb) - 1));
            cigarette_numb = Integer.parseInt(current_numb);
        }
        else {
            Toast.makeText(this, "没有香烟了", Toast.LENGTH_SHORT).show();
            flbtn_cigarette_refresh.setVisibility(View.GONE);

            popDialog();
        }

    }

    private void popDialog() {

        //加载dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        //创建dialog
        final AlertDialog dialog = builder.create();
        dialog.setView(getLayoutInflater().inflate(R.layout.custom_dialog_nosmoke, null));
        dialog.show();
        btn_confirm = (Button) dialog.findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CigaretteSmoke.this, PaymentActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });


    }

    public void smoke(View view) {
        if(currentIndex != 3){
            currentIndex = (currentIndex + 1) % images.length ;
            iv_cigarette_white_part.setImageResource(images[currentIndex]);
        }
        else {
            iv_cigarette_white_part.setImageResource(images[3]);
            Toast.makeText(this, "吸烟完毕,请换一根", Toast.LENGTH_SHORT).show();
        }
    }
}