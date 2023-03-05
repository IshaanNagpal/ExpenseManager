package com.example.expensemanager.di

import com.example.expensemanager.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
object MainActivityModule{

        @Provides
        fun providesHomeViewModel() = HomeViewModel()
}