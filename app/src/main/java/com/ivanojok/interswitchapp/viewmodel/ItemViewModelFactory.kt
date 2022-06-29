package com.ivanojok.interswitchapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ivanojok.interswitchapp.repository.ItemDataRepository


class ItemViewModelFactory(private val repository: ItemDataRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(repository) as T
    }
}