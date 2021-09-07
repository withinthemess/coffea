package com.example.coffea;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContributionCheckList extends AppCompatActivity {

    boolean drynessStatus = false;
    boolean airTightStatus = false;
    boolean tempStatus = false;
    CheckBox drynessCheckBox, airTightCheckBox, tempCheckBox;
    TextView storageTipTxt, coffeeDetailsTxt, coffeeDetailsTip;
    ImageView coffeeDetailsBtn;
    float translationYvalue = -768;
    EditText coffeeDetailsMultiLine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribution_check_list);
        //Hide the navigation bar
        hideNavigationBar();

        drynessCheckBox = findViewById(R.id.checkBox_Dry);
        tempCheckBox = findViewById(R.id.checkBox_temp);
        airTightCheckBox = findViewById(R.id.checkBox_airTight);
        storageTipTxt = findViewById(R.id.storageTip);
        coffeeDetailsBtn = findViewById(R.id.btn_coffeeDetails);
        coffeeDetailsTxt = findViewById(R.id.btn_coffeeDetails_txt);
        coffeeDetailsTip = findViewById(R.id.coffeeDetailsTip);
        coffeeDetailsMultiLine = findViewById(R.id.multiLine_coffeeDetails);

    }

    public void hideCheckBox (View view)
    {
        CheckBox checkbox = (ContributionCheckList.this).findViewById(R.id.checkBox_Dry);
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


    public boolean drynessCheck (View view)
    {
        if( ((CheckBox) view).isChecked() )
        {
            drynessStatus = true;
        }

        return drynessStatus;
    }

    public boolean airTightCheck (View view)
    {
        if( ((CheckBox) view).isChecked() )
        {
            airTightStatus = true;
        }

        return airTightStatus;
    }

    public boolean tempCheck (View view)
    {
        if( ((CheckBox) view).isChecked() )
        {
            tempStatus = true;
        }

        return tempStatus;
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    public void isStorageChecked (View view)
    {
        boolean ready = true;

        if (drynessStatus && airTightStatus && tempStatus)
        {
            Toast.makeText(ContributionCheckList.this, "All Good!", Toast.LENGTH_SHORT).show();

            //Start animation to move to next step
            animateToCoffeeDetails();

        }
        else
        {
            Toast.makeText(ContributionCheckList.this, "Your coffee grounds are not stored well!", Toast.LENGTH_LONG).show();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void animateToCoffeeDetails ()
    {
        //Hide the completed check boxes
        storageTipTxt.animate().alpha(.0f);
        drynessCheckBox.animate().alpha(.0f);
        airTightCheckBox.animate().alpha(.0f);
        tempCheckBox.animate().alpha(.0f);

        //Move the next step into focus
        //Translation Y: Move step up
        coffeeDetailsBtn.animate().translationY(translationYvalue);
        //Change btn color into Forest green (active)
        coffeeDetailsBtn.setColorFilter(ContextCompat.getColor(ContributionCheckList.this, R.color.Forest), PorterDuff.Mode.SRC_IN);
        coffeeDetailsTxt.animate().translationY(translationYvalue);
        //Changing btn text color
        coffeeDetailsTxt.setTextColor(getColor(R.color.Cloud));

        //Show the new coffee details required checks
        coffeeDetailsTip.animate().alpha(1f);
        coffeeDetailsTip.animate().translationY(translationYvalue);
        coffeeDetailsMultiLine.animate().alpha(1f);
        coffeeDetailsMultiLine.animate().translationY(translationYvalue);
    }







}