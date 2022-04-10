package btu.android.homework_5.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import btu.android.homework_5.data.extensions.collectLatestFlow
import btu.android.homework_5.data.extensions.setIntWithAnimation
import btu.android.homework_5.data.extensions.showToast
import btu.android.homework_5.databinding.ActivityUserBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeToObservers()
        init()
    }

    private fun init() {
        setListeners()
    }

    private fun setListeners() = with(binding) {
        saveButton.setOnClickListener {
            viewModel.saveInfo(
                mileage_distance = etRunningDistance.text.toString(),
                swimming_distance = etSwimmingDistance.text.toString(),
                calories_taken = etCalories.text.toString()
            ) {
                showToast("Added Successfully")
            }
        }

        resetButton.setOnClickListener {
            viewModel.clearInfo()
        }
    }

    private fun subscribeToObservers() = with(binding) {

        collectLatestFlow(viewModel.totalDistance) { totalDistance ->
            tvTotalDistance.setIntWithAnimation(totalDistance)
        }

        collectLatestFlow(viewModel.averageCoveredDistance) { avgDistance ->
            tvAvgRunDistance.text = avgDistance
        }

        collectLatestFlow(viewModel.averageCaloriesTaken) { calories ->
            tvAvgCaloriesConsumed.text = calories
        }
    }

}