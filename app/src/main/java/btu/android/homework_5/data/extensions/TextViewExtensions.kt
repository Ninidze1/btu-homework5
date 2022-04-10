package btu.android.homework_5.data.extensions

import android.animation.ValueAnimator
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import kotlin.math.round
import kotlin.math.roundToInt

fun TextView.setIntWithAnimation(finalValue: String, duration: Long = 950) {
    if (finalValue.isDigitsOnly()) {
        val animator = ValueAnimator.ofInt(text.toString().toIntSafely(), finalValue.toIntSafely())
        animator.duration = duration
        animator.addUpdateListener { animation ->
            text = animation.animatedValue.toString()
        }
        animator.start()
    }
}


