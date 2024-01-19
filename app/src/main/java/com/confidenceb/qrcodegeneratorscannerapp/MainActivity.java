package com.confidenceb.qrcodegeneratorscannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button scanner, generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanner = findViewById(R.id.scannerBtn);
        generator = findViewById(R.id.generatorQR);

        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScannerActivity.class);
                startActivity(intent);
            }
        });

        generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QRCodeGenerator.class);
                startActivity(intent);
            }
        });
    }
}