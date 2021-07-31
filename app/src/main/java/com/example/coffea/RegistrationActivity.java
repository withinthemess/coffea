package com.example.coffea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }


    public void toOnBoarding (View view)
    {
        Intent goToOnBoarding = new Intent(RegistrationActivity.this, OnBoardingActivity.class);
        startActivity(goToOnBoarding);
    }


}
