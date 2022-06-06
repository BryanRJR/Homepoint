package com.synrgy.homepoint.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.synrgy.homepoint.data.HomePointRepository

class ViewModelFactory private constructor(private val homePointRepository: HomePointRepository) : NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}