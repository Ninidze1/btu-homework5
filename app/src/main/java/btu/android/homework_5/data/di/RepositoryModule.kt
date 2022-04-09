package btu.android.homework_5.data.di

import btu.android.homework_5.data.repository.abstraction.IUserRepository
import btu.android.homework_5.data.repository.implementation.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(userRepository: UserRepository): IUserRepository
}