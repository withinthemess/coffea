package com.example.coffea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.coffea.R

class MainContributingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_contributing)

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

    fun toContributionChecklist(view: View?) {
        //    Intent goToContributionChecklist = new Intent (MainContributingActivity.this, ContributionCheckList.class);
        //    startActivity(goToContributionChecklist);
    }
}