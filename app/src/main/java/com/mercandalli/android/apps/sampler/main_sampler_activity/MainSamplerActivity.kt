package com.mercandalli.android.apps.sampler.main_sampler_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.mercandalli.android.apps.sampler.R

class MainSamplerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_sampler_activity)

        FirebaseDatabase.getInstance().getReference("whatever")
    }
}
