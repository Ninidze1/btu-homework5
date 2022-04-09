package btu.android.homework_5.data.repository.abstraction

import btu.android.homework_5.data.db.UserEntity
import btu.android.homework_5.ui.model.UserUi
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    suspend fun getAll(): Flow<List<UserUi>>

    suspend fun getTotalRunDistance(): Flow<Int>

    suspend fun getAverageCoveredDistance(): Flow<Double>

    suspend fun getAverageCaloriesTaken(): Flow<Double>

    suspend fun insert(user: UserUi)

    suspend fun delete(user: UserUi)
}