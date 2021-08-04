package com.example.coffea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
    }


    public void toHome (View view)
    {
        Intent goToHome = new Intent (OnBoardingActivity.this, HomeActivity.class);
        startActivity(goToHome);
    }
}