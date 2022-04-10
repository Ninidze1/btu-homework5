package btu.android.homework_5.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import btu.android.homework_5.data.extensions.toIntSafely
import btu.android.homework_5.ui.model.UserUi

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "mileage_distance") val mileage_distance: Int,
    @ColumnInfo(name = "swimming_distance") val swimming_distance: Int,
    @ColumnInfo(name = "calories_taken") val calories_taken: Int
) {
    companion object {
        fun fromPresentation(type: UserUi): UserEntity {
            return UserEntity(
                id = type.id ?: 0,
                mileage_distance = type.mileage_distance?.toIntSafely() ?: 0,
                swimming_distance = type.swimming_distance?.toIntSafely() ?: 0,
                calories_taken = type.calories_taken?.toIntSafely() ?: 0
            )
        }
    }
}