package com.example.whac_a_mole

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APP_PREFERENCES = getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}