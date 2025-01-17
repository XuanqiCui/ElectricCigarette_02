package com.starwar.electriccigarette_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaymentActivity extends AppCompatActivity {

    private Button btn_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        initView();
    }

    private void initView() {
        btn_payment = (Button) findViewById(R.id.btn_payment);
    }


    public void payment(View view) {
        Toast.makeText(this,"不，你没有付款",Toast.LENGTH_SHORT).show();
    }
}