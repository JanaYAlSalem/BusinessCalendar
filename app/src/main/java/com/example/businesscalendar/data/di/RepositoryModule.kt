package com.example.businesscalendar.data.di

import com.example.businesscalendar.data.local.repository.IReminderRepository
import com.example.businesscalendar.data.local.repository.OfflineReminderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindReminderRepository(offlineReminderRepository: OfflineReminderRepository): IReminderRepository
}