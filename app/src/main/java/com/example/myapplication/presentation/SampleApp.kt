package com.example.myapplication.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.composable
import com.example.myapplication.app.Screen.Exercise
import com.example.myapplication.presentation.exercise.ExerciseScreen
import com.example.myapplication.presentation.exercise.ExerciseViewModel
import com.google.android.horologist.compose.navscaffold.WearNavScaffold


@Composable
fun SampleApp(
    navController: NavHostController,
    onFinishActivity: () -> Unit
) {

    val exerciseViewModel: ExerciseViewModel = viewModel()

    WearNavScaffold(
        navController = navController,
        startDestination = Exercise.route
    ) {

        composable(Exercise.route){
            ExerciseScreen(viewModel = exerciseViewModel)
        }

//        composable(PreparingExercise.route) {
//
//        }


    }
}