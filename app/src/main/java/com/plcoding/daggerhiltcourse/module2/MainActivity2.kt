package com.plcoding.daggerhiltcourse.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.plcoding.daggerscopes.ui.theme.DaggerScopesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

// Chceme SessionTimer injectovat do viewmodelu
// Ak bude jeho zivotnost rovnaka ako zivotnost aplikacie jeho stav ostane tiez nazive
// Teda ak ho pouzijem znova niekde casovac bude pokracovat tam kde prestal
// Preto do stopTimer() dam sessionTime = 0
// Toto nie je vhodne riesenie preto pri DI nastavim jeho zivotnost len na dlzku viewmodela.

// Co ak ale mam pripad ze ho chcem pouzit pri dvoch screenach
// Treba ho nejako sharovat medzi nimi.

// 1. sposob je scopnut viewmodel na Activitu v ktorej budu tie dve screeny (ActiviComponent)
// Neni vhodne riesenie pretoze moze byt len jedna aktivita a tym to je vlastne aj tak iba "Singleton"
// A v Compose nepouzivame ani Fragmenty

// 2. sposob je scopnut viewmodel na NavigationGraph (jeho life time)
// Cize bude zit pokial je v nejakej screene toho NavigationGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerScopesTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "start_destination") {

                    // sa pouzije na nested navigation
                    // na tento graph sa budu viewmodely scopovat budu mat jeho zivotnost
                    navigation(
                        startDestination = "video_call_screen",
                        route = "video_graph"
                    ) {
                        composable("video_call_screen") { backStackEntry ->
                            // z backStackEntry dostanem lifecycle info screenov
                            // pouzijeme to na scopnutie viewmodelu na tento graph (navigation)

                            // ak by som chcel scopnut viewmodel len tuto aktualnu screenu urobim to takto:
                            // val viewModel = hiltViewModel<SessionViewModel>(backStackEntry)

                            // ale ja chcem scopnut viewmodel pre dve screeny
                            // lebo chcem sharovat SessionTimer instanciu medzi dvoma screenami
                            // robi sa to takto:

                            // ked sa backStackEntry zmeni vsetko v tejto lambde sa vykona znova
                            val parentEntry = remember(backStackEntry) {
                                // chcem backStackEntry tohto graphu (navigation)
                                navController.getBackStackEntry("video_graph")
                            }
                            val viewModel = hiltViewModel<SessionViewModel>(parentEntry)
                        }

                        composable("call_info_screen") { backStackEntry ->
                            val parentEntry = remember(backStackEntry) {
                                navController.getBackStackEntry("video_graph")
                            }
                            // oba viewmodely budu mat rovnaku instanciu
                            // lebo su scopnute na rovnaky graph (navigation)
                            val viewModel = hiltViewModel<SessionViewModel>(parentEntry)
                        }
                    }
                }
            }
        }
    }
}