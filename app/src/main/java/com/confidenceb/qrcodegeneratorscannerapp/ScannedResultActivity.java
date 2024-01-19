package com.confidenceb.qrcodegeneratorscannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;

public class ScannedResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_result);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("scannedData")) {
            String scannedData = intent.getStringExtra("scannedData");

            TextView resultTextView = findViewById(R.id.resultTextView);
            resultTextView.setText(scannedData);

            // Check if the scanned data is a valid URL
            if (URLUtil.isValidUrl(scannedData)) {
                // If it's a URL, open it in a web browser
                openUrl(scannedData);
            } else {
                Toast.makeText(this, "Not a valid URL", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openUrl(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}