package btu.android.homework_5.data.repository.abstraction

import btu.android.homework_5.ui.model.UserUi
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    fun getTotalRunDistance(): Flow<String>

    fun getAverageCoveredDistance(): Flow<String>

    fun getAverageCaloriesTaken(): Flow<String>

    suspend fun insert(user: UserUi)

    suspend fun deleteAll()
}