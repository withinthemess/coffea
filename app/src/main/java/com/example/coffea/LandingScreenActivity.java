package com.example.coffea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LandingScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_screen);
    }


    public void toRegistration(View view )
    {
        Intent goToRegistration = new Intent(LandingScreenActivity.this, AuthActivity.class);
        startActivity(goToRegistration);
    }




}   