package com.example.coffea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }



    public void toContributing (View view)
    {
        Intent goToContributing = new Intent (HomeActivity.this, MainContributingActivity.class);
        startActivity(goToContributing);
    }
}