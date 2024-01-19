package com.confidenceb.qrcodegeneratorscannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator extends AppCompatActivity {

    private EditText inputEditText;
    private Button generateButton;
    private ImageView qrCodeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_generator);

        inputEditText = findViewById(R.id.inputEditText);
        generateButton = findViewById(R.id.generateButton);
        qrCodeImageView = findViewById(R.id.qrCodeImageView);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQRCode();
            }
        });
    }

    private void generateQRCode() {
        String inputData = inputEditText.getText().toString().trim();

        if (!inputData.isEmpty()) {
            try {
                // Generate QR code
                QRCodeWriter writer = new QRCodeWriter();
                BitMatrix bitMatrix = writer.encode(inputData, BarcodeFormat.QR_CODE, 512, 512);
                int width = bitMatrix.getWidth();
                int height = bitMatrix.getHeight();
                Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        bitmap.setPixel(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                    }
                }

                // Display the generated QR code
                qrCodeImageView.setImageBitmap(bitmap);

            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
    }
}