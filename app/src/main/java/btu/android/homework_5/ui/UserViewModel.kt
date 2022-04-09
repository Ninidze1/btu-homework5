package btu.android.homework_5.ui

import androidx.lifecycle.ViewModel
import btu.android.homework_5.data.repository.abstraction.IUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(userRepository: IUserRepository) : ViewModel() {

}