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
        //Hide the navigation bar
        hideNavigationBar();
    }

    //Hide navigation bar even after going out and coming back to the app
    @Override
    protected void onResume()
    {
        super.onResume();
        hideNavigationBar();
    }


    //Hide the navigation bar
    private void hideNavigationBar ()
    {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );




    }


    public void toAuthentication (View view)
    {
        Intent goToAuthentication = new Intent(LandingScreenActivity.this, AuthActivity.class);
        startActivity(goToAuthentication);
    }

    public void toRegistration(View view)
    {
        Intent goToRegistration = new Intent(LandingScreenActivity.this, RegistrationActivity.class);
        startActivity(goToRegistration);
    }

    public void toHome (View view)
    {
        Intent goToHome = new Intent (LandingScreenActivity.this, ContributionCheckList.class);
        startActivity(goToHome);
    }


}   