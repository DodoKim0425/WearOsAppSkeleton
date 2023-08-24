package com.example.myapplication.presentation.exercise

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.Scaffold
import com.example.myapplication.presentation.common.ButtonExample
import com.example.myapplication.presentation.common.CardExample
import com.example.myapplication.presentation.common.ChipExample
import com.example.myapplication.presentation.common.TextExample
import com.example.myapplication.presentation.common.ToggleChipExample
import androidx.hilt.navigation.compose.hiltViewModel

private const val TAG = "ExerciseScreen"
@Composable
fun ExerciseScreen(
    viewModel: ExerciseViewModel
) {
    val listState = rememberScalingLazyListState()
    //val viewModel = hiltViewModel<ExerciseViewModel>()
    Scaffold() {
        // Modifiers used by our Wear composables.
        val contentModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
        val iconModifier = Modifier
            .size(24.dp)
            .wrapContentSize(align = Alignment.Center)

        /* *************************** Part 3: ScalingLazyColumn *************************** */
        // TODO: Swap a ScalingLazyColumn (Wear's version of LazyColumn)
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = listState
        ) {

            /* ******************* Part 1: Simple composables ******************* */
            item {
                ButtonExample(contentModifier, iconModifier) {
                    Log.d(TAG, "ExerciseScreen: clicked!!!!!!!!!")
                    viewModel.getTestString()
                }
            }
            item { TextExample(contentModifier) }
            item { CardExample(contentModifier, iconModifier) }

            /* ********************* Part 2: Wear unique composables ********************* */
            item { ChipExample(contentModifier, iconModifier) }
            item { ToggleChipExample(contentModifier) }
        }
    }
}
