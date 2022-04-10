package btu.android.homework_5.data.extensions

fun String.toIntSafely(): Int {
    return if (this == "") {
        0
    } else {
        toInt()
    }
}