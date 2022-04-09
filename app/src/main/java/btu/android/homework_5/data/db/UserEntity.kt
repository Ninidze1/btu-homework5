package btu.android.homework_5.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import btu.android.homework_5.ui.model.UserUi

@Entity
data class UserEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "mileage_distance") val mileage_distance: Int?,
    @ColumnInfo(name = "swimming_distance") val swimming_distance: Int?,
    @ColumnInfo(name = "calories_taken") val calories_taken: Int?
) {
    companion object {
        fun fromPresentation(type: UserUi): UserEntity {
            return UserEntity(
                id = type.id,
                mileage_distance = type.mileage_distance ?: 0,
                swimming_distance = type.swimming_distance ?: 0,
                calories_taken = type.calories_taken ?: 0
            )
        }
    }

    fun toPresentation(): UserUi {
        return UserUi(
            id = id,
            mileage_distance = mileage_distance ?: 0,
            swimming_distance = swimming_distance ?: 0,
            calories_taken = calories_taken ?: 0
        )
    }
}