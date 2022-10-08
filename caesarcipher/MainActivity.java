package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btEnkripsi, btDekripsi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEnkripsi = findViewById(R.id.bt_enkripsi);
        btDekripsi = findViewById(R.id.bt_dekripsi);

        btEnkripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, EnkripsiActivity.class);
                startActivity(intent1);
            }
        });

        btDekripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, DekripsiActivity.class);
                startActivity(intent2);
            }
        });
    }
}