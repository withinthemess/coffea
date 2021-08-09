package com.example.coffea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainContributingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contributing);
    }



    public void toContributionChecklist (View view)
    {
        Intent goToContributionChecklist = new Intent (MainContributingActivity.this, ContributionCheckList.class);
        startActivity(goToContributionChecklist);
    }
}