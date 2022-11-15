package com.example.coffea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coffea.R
import android.content.Intent
import android.view.View
import com.example.coffea.RegistrationActivity
import com.example.coffea.ContributionCheckList

class LandingScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_screen)
        //Hide the navigation bar
        hideNavigationBar()
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

    fun toAuthentication(view: View?) {
        //    Intent goToAuthentication = new Intent(LandingScreenActivity.this, AuthActivity.class);
        //   startActivity(goToAuthentication);
    }

    fun toRegistration(view: View?) {
    //    val goToRegistration = Intent(this@LandingScreenActivity, RegistrationActivity::class.java)
    //    startActivity(goToRegistration)
    }

    fun toHome(view: View?) {
    //    val goToHome = Intent(this@LandingScreenActivity, ContributionCheckList::class.java)
    //    startActivity(goToHome)
    }
}