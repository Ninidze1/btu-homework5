package btu.android.homework_5.data.repository.implementation

import btu.android.homework_5.data.db.AppDatabase
import btu.android.homework_5.data.db.UserDao
import btu.android.homework_5.data.db.UserEntity
import btu.android.homework_5.data.repository.abstraction.IUserRepository
import btu.android.homework_5.ui.model.UserUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepository @Inject constructor(private val db: UserDao) : IUserRepository {

    override suspend fun getAll(): Flow<List<UserUi>> {
        return db.getAll().map { users ->
            users.map { it.toPresentation() }
        }
    }

    override suspend fun insert(user: UserUi) = db.insert(
        UserEntity.fromPresentation(type = user)
    )

    override suspend fun delete(user: UserUi) = db.delete(
        UserEntity.fromPresentation(type = user)
    )

    override suspend fun getTotalRunDistance(): Flow<Int> = db.getTotalRunDistance()

    override suspend fun getAverageCoveredDistance(): Flow<Double> = db.getAverageCoveredDistance()

    override suspend fun getAverageCaloriesTaken(): Flow<Double> = db.getAverageCaloriesTaken()

}