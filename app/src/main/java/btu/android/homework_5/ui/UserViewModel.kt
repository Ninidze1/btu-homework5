package btu.android.homework_5.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import btu.android.homework_5.data.extensions.toIntSafely
import btu.android.homework_5.data.repository.abstraction.IUserRepository
import btu.android.homework_5.ui.model.UserUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: IUserRepository) : ViewModel() {

    val totalDistance = userRepository.getTotalRunDistance()
    val averageCoveredDistance = userRepository.getAverageCoveredDistance()
    val averageCaloriesTaken = userRepository.getAverageCaloriesTaken()

    fun saveInfo(
        mileage_distance: String,
        swimming_distance: String,
        calories_taken: String,
        block: () -> Unit
    ) {
        viewModelScope.launch {
            userRepository.insert(
                user = UserUi(
                    id = 0,
                    mileage_distance = mileage_distance,
                    swimming_distance = swimming_distance,
                    calories_taken = calories_taken
                )
            )
            block.invoke()
        }
    }

    fun clearInfo() {
        viewModelScope.launch {
            userRepository.deleteAll()
        }
    }

}