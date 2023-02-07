package com.plcoding.daggerhiltcourse.module2.ui

import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.plcoding.daggerhiltcourse.R
import com.plcoding.daggerhiltcourse.module2.SessionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallInfoFragment: Fragment() {

    // oba fragmenty budu scopnute na navigacny graph
    // budu mat rovnaku instanciu SessionViewModelu
    // Takto to funguje s XML

    //private val viewModel: SessionViewModel by navGraphViewModels(R.navigation.nested_graph)
}