package com.apuestatotal.app.di

import com.apuestatotal.app.data.datasource.RemoteDataSource
import com.apuestatotal.app.data.datasource.RemoteDataSourceImpl
import com.apuestatotal.app.data.remote.BetApiClient
import com.apuestatotal.app.data.repository.BetRepositoryImpl
import com.apuestatotal.app.data.repository.UserRepositoryImpl
import com.apuestatotal.app.domain.repository.BetRepository
import com.apuestatotal.app.domain.repository.UserRepository
import com.apuestatotal.app.domain.usecase.GetBetHistoryUseCase
import com.apuestatotal.app.domain.usecase.SignInUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        apiClient: BetApiClient
    ): RemoteDataSource {
        return RemoteDataSourceImpl(apiClient)
    }

    @Provides
    @Singleton
    fun provideBetRepository(
        remoteDataSource: RemoteDataSource
    ): BetRepository {
        return BetRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetBetHistoryUseCase(
        betRepository: BetRepository
    ): GetBetHistoryUseCase {
        return GetBetHistoryUseCase(betRepository)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        remoteDataSource: RemoteDataSource
    ): UserRepository {
        return UserRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideSignInUseCase(
        userRepository: UserRepository
    ): SignInUseCase {
        return SignInUseCase(userRepository)
    }
}
