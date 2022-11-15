package com.example.coffea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coffea.R
import androidx.annotation.RequiresApi
import android.os.Build
import androidx.core.content.ContextCompat
import android.graphics.PorterDuff
import android.view.View
import android.widget.*

class ContributionCheckList : AppCompatActivity() {
    var drynessStatus = false
    var airTightStatus = false
    var tempStatus = false
    var drynessCheckBox: CheckBox? = null
    var airTightCheckBox: CheckBox? = null
    var tempCheckBox: CheckBox? = null
    var storageTipTxt: TextView? = null
    var coffeeDetailsTxt: TextView? = null
    var coffeeDetailsTip: TextView? = null
    var yourLocationTxt: TextView? = null
    var yourLocationTip: TextView? = null
    var useMyLocationTxt: TextView? = null
    var useMyAddressTxt: TextView? = null
    var pickUpDateTxt: TextView? = null
    var pickUpDateTip: TextView? = null
    var confirmedPickUpDate: TextView? = null
    var confirmContributionTxt: TextView? = null
    var coffeeDetailsBtn: ImageView? = null
    var yourLocationBtn: ImageView? = null
    var useMyLocationBtn: ImageView? = null
    var useMyAddressBtn: ImageView? = null
    var icGlobe: ImageView? = null
    var icDirection: ImageView? = null
    var pickUpDateBtn: ImageView? = null
    var icCorrect: ImageView? = null
    var confirmContributionBtn: ImageView? = null
    var coffeeDetailsMultiLine: EditText? = null
    var translationYvalue = -700f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contribution_check_list)
        //Hide the navigation bar
        hideNavigationBar()

        //Linking the objects with the xml views
        drynessCheckBox = findViewById(R.id.checkBox_Dry)
        tempCheckBox = findViewById(R.id.checkBox_temp)
        airTightCheckBox = findViewById(R.id.checkBox_airTight)
        storageTipTxt = findViewById(R.id.storageTip)
        coffeeDetailsBtn = findViewById(R.id.btn_coffeeDetails)
        coffeeDetailsTxt = findViewById(R.id.btn_coffeeDetails_txt)
        coffeeDetailsTip = findViewById(R.id.coffeeDetailsTip)
        coffeeDetailsMultiLine = findViewById(R.id.multiLine_coffeeDetails)
        yourLocationBtn = findViewById(R.id.btn_yourLocation)
        yourLocationTxt = findViewById(R.id.btn_yourLocation_txt)
        yourLocationTip = findViewById(R.id.yourLocationTip)
        useMyAddressBtn = findViewById(R.id.btn_useMyAddress)
        useMyAddressTxt = findViewById(R.id.btn_useMyAddress_txt)
        useMyLocationBtn = findViewById(R.id.btn_useMyLocation)
        useMyLocationTxt = findViewById(R.id.btn_useMyLocation_txt)
        icGlobe = findViewById(R.id.ic_globe)
        icDirection = findViewById(R.id.ic_direction)
        pickUpDateTxt = findViewById(R.id.btn_pickDate_txt)
        pickUpDateBtn = findViewById(R.id.btn_pickDate)
        icCorrect = findViewById(R.id.ic_correct)
        confirmedPickUpDate = findViewById(R.id.confirmedDateTxt)
        pickUpDateTip = findViewById(R.id.pickUpDateTip)
        confirmContributionBtn = findViewById(R.id.btn_confirmContribution)
        confirmContributionTxt = findViewById(R.id.btn_confirmContributionTxt)
    }

    fun hideCheckBox(view: View?) {
        val checkbox = findViewById<CheckBox>(R.id.checkBox_Dry)
        checkbox.alpha = 0.0f
    }

    //Hide navigation bar even after going out and coming back to the app
    override fun onResume() {
        super.onResume()
        hideNavigationBar()
    }

    //Hide the navigation bar
    private fun hideNavigationBar() {
        this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    }

    fun drynessCheck(view: View): Boolean {
        if ((view as CheckBox).isChecked) {
            drynessStatus = true
        }
        return drynessStatus
    }

    fun airTightCheck(view: View): Boolean {
        if ((view as CheckBox).isChecked) {
            airTightStatus = true
        }
        return airTightStatus
    }

    fun tempCheck(view: View): Boolean {
        if ((view as CheckBox).isChecked) {
            tempStatus = true
        }
        return tempStatus
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    fun isStorageChecked(view: View?) {
        val ready = true
        if (drynessStatus && airTightStatus && tempStatus) {
            Toast.makeText(this@ContributionCheckList, "All Good!", Toast.LENGTH_SHORT).show()

            //Start animation to move to next step
            animateToCoffeeDetails()
        } else {
            Toast.makeText(
                this@ContributionCheckList,
                "Your coffee grounds are not stored well!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun animateToCoffeeDetails() {
        //Hide the completed check boxes (Storage check boxes)
        storageTipTxt!!.animate().alpha(0f)
        drynessCheckBox!!.animate().alpha(0f)
        airTightCheckBox!!.animate().alpha(0f)
        tempCheckBox!!.animate().alpha(0f)

        //Move the next step into focus
        //Translation Y: Move step up
        coffeeDetailsBtn!!.animate().translationY(translationYvalue)
        //Change btn color into Forest green (active)
        coffeeDetailsBtn!!.setColorFilter(
            ContextCompat.getColor(
                this@ContributionCheckList,
                R.color.Forest
            ), PorterDuff.Mode.SRC_IN
        )
        coffeeDetailsTxt!!.animate().translationY(translationYvalue)
        //Changing btn text color
        coffeeDetailsTxt!!.setTextColor(getColor(R.color.Cloud))

        //Show the new coffee details required checks
        coffeeDetailsTip!!.animate().alpha(1f)
        coffeeDetailsTip!!.animate().translationY(translationYvalue)
        coffeeDetailsMultiLine!!.animate().alpha(1f)
        coffeeDetailsMultiLine!!.animate().translationY(translationYvalue)
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    fun animateToYourLocationDetails(view: View?) {
        //Hide completed section [coffee details]
        coffeeDetailsTip!!.animate().alpha(0f)
        coffeeDetailsMultiLine!!.animate().alpha(0f)

        //Move the next step into focus
        yourLocationBtn!!.animate().translationY(translationYvalue)
        yourLocationTxt!!.animate().translationY(translationYvalue)
        yourLocationTip!!.animate().translationY(translationYvalue)
        useMyLocationBtn!!.animate().translationY(translationYvalue)
        useMyLocationTxt!!.animate().translationY(translationYvalue)
        icDirection!!.animate().translationY(translationYvalue)
        useMyAddressBtn!!.animate().translationY(translationYvalue)
        useMyAddressTxt!!.animate().translationY(translationYvalue)
        icGlobe!!.animate().translationY(translationYvalue)


        //Change Button to active visually
        yourLocationBtn!!.setColorFilter(
            ContextCompat.getColor(
                this@ContributionCheckList,
                R.color.Forest
            ), PorterDuff.Mode.SRC_IN
        )
        yourLocationTxt!!.setTextColor(getColor(R.color.Cloud))

        //Show new checks
        yourLocationTip!!.animate().alpha(1f)
        useMyLocationBtn!!.animate().alpha(1f)
        useMyLocationTxt!!.animate().alpha(1f)
        icDirection!!.animate().alpha(1f)
        useMyAddressBtn!!.animate().alpha(1f)
        useMyAddressTxt!!.animate().alpha(1f)
        icGlobe!!.animate().alpha(1f)
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    fun animateToPickDate(view: View?) {
        //Hide the completed location check
        yourLocationTip!!.animate().alpha(0f)
        useMyLocationBtn!!.animate().alpha(0f)
        useMyLocationTxt!!.animate().alpha(0f)
        icDirection!!.animate().alpha(0f)
        useMyAddressBtn!!.animate().alpha(0f)
        useMyAddressTxt!!.animate().alpha(0f)
        icGlobe!!.animate().alpha(0f)

        //Move the next step into focus
        pickUpDateBtn!!.animate().translationY(translationYvalue)
        pickUpDateTxt!!.animate().translationY(translationYvalue)
        icCorrect!!.animate().translationY(translationYvalue)
        pickUpDateTip!!.animate().translationY(translationYvalue)
        confirmedPickUpDate!!.animate().translationY(translationYvalue)
        //confirmContributionBtn.animate().translationY(translationYvalue);
        //confirmContributionTxt.animate().translationY(translationYvalue);


        //Show new checks
        pickUpDateTip!!.animate().alpha(1f)
        confirmedPickUpDate!!.animate().alpha(1f)
        confirmContributionBtn!!.animate().alpha(1f)
        confirmContributionTxt!!.animate().alpha(1f)


        //Change Button to active visually
        pickUpDateBtn!!.setColorFilter(
            ContextCompat.getColor(
                this@ContributionCheckList,
                R.color.Forest
            ), PorterDuff.Mode.SRC_IN
        )
        icCorrect!!.setColorFilter(
            ContextCompat.getColor(
                this@ContributionCheckList,
                R.color.Cloud
            ), PorterDuff.Mode.SRC_IN
        )
        pickUpDateTxt!!.setTextColor(getColor(R.color.Cloud))
    }

    fun toHome(view: View?) {
        //    Intent goToHome = new Intent(ContributionCheckList.this, HomeActivity.class);
        //    startActivity(goToHome);
    }
}