package com.example.echosafefrontend;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 5-second delay before navigating to Registration page
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();  // Close MainActivity to prevent returning to it
            }
        }, 5000);  // 5000 milliseconds = 5 seconds
    }
}
