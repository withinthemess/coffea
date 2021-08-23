package com.example.coffea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class ContributionCheckList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribution_check_list);
        //Hide the navigation bar
        hideNavigationBar();
    }

    public void hideCheckBox (View view)
    {
        CheckBox checkbox = (ContributionCheckList.this).findViewById(R.id.myCheckbox_1);
        checkbox.setAlpha(0.0f);
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

}