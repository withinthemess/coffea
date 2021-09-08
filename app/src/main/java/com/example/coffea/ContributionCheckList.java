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

    TextView storageTipTxt, coffeeDetailsTxt, coffeeDetailsTip, yourLocationTxt, yourLocationTip,
            useMyLocationTxt, useMyAddressTxt, pickUpDateTxt, pickUpDateTip, confirmedPickUpDate,
            confirmContributionTxt;

    ImageView coffeeDetailsBtn, yourLocationBtn, useMyLocationBtn, useMyAddressBtn, icGlobe,
            icDirection, pickUpDateBtn, icCorrect, confirmContributionBtn;

    EditText coffeeDetailsMultiLine;

    float translationYvalue = -700;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribution_check_list);
        //Hide the navigation bar
        hideNavigationBar();

        //Linking the objects with the xml views
        drynessCheckBox = findViewById(R.id.checkBox_Dry);
        tempCheckBox = findViewById(R.id.checkBox_temp);
        airTightCheckBox = findViewById(R.id.checkBox_airTight);
        storageTipTxt = findViewById(R.id.storageTip);
        coffeeDetailsBtn = findViewById(R.id.btn_coffeeDetails);
        coffeeDetailsTxt = findViewById(R.id.btn_coffeeDetails_txt);
        coffeeDetailsTip = findViewById(R.id.coffeeDetailsTip);
        coffeeDetailsMultiLine = findViewById(R.id.multiLine_coffeeDetails);
        yourLocationBtn = findViewById(R.id.btn_yourLocation);
        yourLocationTxt = findViewById(R.id.btn_yourLocation_txt);
        yourLocationTip = findViewById(R.id.yourLocationTip);
        useMyAddressBtn = findViewById(R.id.btn_useMyAddress);
        useMyAddressTxt  = findViewById(R.id.btn_useMyAddress_txt);
        useMyLocationBtn = findViewById(R.id.btn_useMyLocation);
        useMyLocationTxt  = findViewById(R.id.btn_useMyLocation_txt);
        icGlobe  = findViewById(R.id.ic_globe);
        icDirection  = findViewById(R.id.ic_direction);
        pickUpDateTxt = findViewById(R.id.btn_pickDate_txt);
        pickUpDateBtn = findViewById(R.id.btn_pickDate);
        icCorrect = findViewById(R.id.ic_correct);
        confirmedPickUpDate = findViewById(R.id.confirmedDateTxt);
        pickUpDateTip = findViewById(R.id.pickUpDateTip);
        confirmContributionBtn = findViewById(R.id.btn_confirmContribution);
        confirmContributionTxt = findViewById(R.id.btn_confirmContributionTxt);

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
        //Hide the completed check boxes (Storage check boxes)
        storageTipTxt.animate().alpha(0f);
        drynessCheckBox.animate().alpha(0f);
        airTightCheckBox.animate().alpha(0f);
        tempCheckBox.animate().alpha(0f);

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


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void animateToYourLocationDetails (View view)
    {
        //Hide completed section [coffee details]
        coffeeDetailsTip.animate().alpha(0f);
        coffeeDetailsMultiLine.animate().alpha(0f);

        //Move the next step into focus
        yourLocationBtn.animate().translationY(translationYvalue);
        yourLocationTxt.animate().translationY(translationYvalue);
        yourLocationTip.animate().translationY(translationYvalue);
        useMyLocationBtn.animate().translationY(translationYvalue);
        useMyLocationTxt.animate().translationY(translationYvalue);
        icDirection.animate().translationY(translationYvalue);
        useMyAddressBtn.animate().translationY(translationYvalue);
        useMyAddressTxt.animate().translationY(translationYvalue);
        icGlobe.animate().translationY(translationYvalue);


        //Change Button to active visually
        yourLocationBtn.setColorFilter(ContextCompat.getColor(ContributionCheckList.this, R.color.Forest), PorterDuff.Mode.SRC_IN);
        yourLocationTxt.setTextColor(getColor(R.color.Cloud));

        //Show new checks
        yourLocationTip.animate().alpha(1f);
        useMyLocationBtn.animate().alpha(1f);
        useMyLocationTxt.animate().alpha(1f);
        icDirection.animate().alpha(1f);
        useMyAddressBtn.animate().alpha(1f);
        useMyAddressTxt.animate().alpha(1f);
        icGlobe.animate().alpha(1f);

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void animateToPickDate (View view)
    {
        //Hide the completed location check
        yourLocationTip.animate().alpha(0f);
        useMyLocationBtn.animate().alpha(0f);
        useMyLocationTxt.animate().alpha(0f);
        icDirection.animate().alpha(0f);
        useMyAddressBtn.animate().alpha(0f);
        useMyAddressTxt.animate().alpha(0f);
        icGlobe.animate().alpha(0f);

        //Move the next step into focus
        pickUpDateBtn.animate().translationY(translationYvalue);
        pickUpDateTxt.animate().translationY(translationYvalue);
        icCorrect.animate().translationY(translationYvalue);
        pickUpDateTip.animate().translationY(translationYvalue);
        confirmedPickUpDate.animate().translationY(translationYvalue);
        //confirmContributionBtn.animate().translationY(translationYvalue);
        //confirmContributionTxt.animate().translationY(translationYvalue);


        //Show new checks
        pickUpDateTip.animate().alpha(1f);
        confirmedPickUpDate.animate().alpha(1f);
        confirmContributionBtn.animate().alpha(1f);
        confirmContributionTxt.animate().alpha(1f);




        //Change Button to active visually
        pickUpDateBtn.setColorFilter(ContextCompat.getColor(ContributionCheckList.this, R.color.Forest), PorterDuff.Mode.SRC_IN);
        icCorrect.setColorFilter(ContextCompat.getColor(ContributionCheckList.this, R.color.Cloud), PorterDuff.Mode.SRC_IN);
        pickUpDateTxt.setTextColor(getColor(R.color.Cloud));



    }




}