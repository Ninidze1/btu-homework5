package btu.android.homework_5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import btu.android.homework_5.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}