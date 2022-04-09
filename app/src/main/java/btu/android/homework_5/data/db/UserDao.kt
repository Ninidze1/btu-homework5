package btu.android.homework_5.data.db


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM userentity")
    fun getAll(): Flow<List<UserEntity>>

    @Query("SELECT sum(mileage_distance) FROM userentity")
    fun getTotalRunDistance(): Flow<Int>

    @Query("SELECT (sum(mileage_distance) + sum(swimming_distance) / count(*)) FROM userentity")
    fun getAverageCoveredDistance(): Flow<Double>

    @Query("SELECT (sum(calories_taken) / count(*)) FROM userentity")
    fun getAverageCaloriesTaken(): Flow<Double>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)
}