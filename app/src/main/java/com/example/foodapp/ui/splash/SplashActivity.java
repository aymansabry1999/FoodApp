package com.example.foodapp.ui.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivitySplachBinding;
import com.example.foodapp.ui.main.MainActivity;
import com.squareup.picasso.Picasso;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplachBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splach);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });
        thread.start();


    }
}