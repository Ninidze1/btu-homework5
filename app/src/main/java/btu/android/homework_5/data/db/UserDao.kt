package btu.android.homework_5.data.db


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT sum(mileage_distance) + sum(swimming_distance) FROM userentity")
    fun getTotalRunDistance(): Flow<Int?>

    @Query("SELECT (sum(mileage_distance) + sum(swimming_distance) / count(*)) FROM userentity")
    fun getAverageCoveredDistance(): Flow<Float?>

    @Query("SELECT (sum(calories_taken) / count(*)) FROM userentity")
    fun getAverageCaloriesTaken(): Flow<Float?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Query("DELETE FROM userentity")
    suspend fun deleteAll()
}