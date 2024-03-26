package com.pushkovav.medic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pushkovav.medic.fragment.AnalyzeFragment
import com.pushkovav.medic.fragment.ProfileFragment
import com.pushkovav.medic.fragment.ResultFragment
import com.pushkovav.medic.fragment.SupportFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(AnalyzeFragment())
    }

    override fun onResume() {
        super.onResume()
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.analyze -> replaceFragment(AnalyzeFragment())
                R.id.results -> replaceFragment(ResultFragment())
                R.id.support -> replaceFragment(SupportFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}