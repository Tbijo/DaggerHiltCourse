package com.plcoding.daggerhiltcourse.module1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.daggerhiltcourse.module1.ui.theme.DaggerHiltCourseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltCourseTheme {
                // viewModel is scoped to NavGraph if there isnt one then to current activity
                val viewModel = hiltViewModel<MyViewModel>()
            }
        }
    }
}