package btu.android.homework_5.data.repository.implementation

import btu.android.homework_5.data.db.UserDao
import btu.android.homework_5.data.db.UserEntity
import btu.android.homework_5.data.repository.abstraction.IUserRepository
import btu.android.homework_5.ui.model.UserUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepository @Inject constructor(private val db: UserDao) : IUserRepository {

    override suspend fun insert(user: UserUi) = db.insert(
        UserEntity.fromPresentation(type = user)
    )

    override suspend fun deleteAll() = db.deleteAll()

    override fun getTotalRunDistance(): Flow<String> =
        db.getTotalRunDistance().map { it?.toString() ?: "0" }

    override fun getAverageCoveredDistance(): Flow<String> =
        db.getAverageCoveredDistance().map { it?.toString() ?: "0.0" }

    override fun getAverageCaloriesTaken(): Flow<String> =
        db.getAverageCaloriesTaken().map { it?.toString() ?: "0.0" }

}