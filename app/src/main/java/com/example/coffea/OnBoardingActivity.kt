package com.example.coffea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.coffea.R

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
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

    fun toHome(view: View?) {
        //    Intent goToHome = new Intent (OnBoardingActivity.this, HomeActivity.class);
        //    startActivity(goToHome);
    }
}