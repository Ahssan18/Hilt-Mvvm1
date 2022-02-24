package com.codingwithmitch.daggerhiltplayground.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.codingwithmitch.daggerhiltplayground.model.Posts
import com.codingwithmitch.daggerhiltplayground.repository.MainRepository
import com.codingwithmitch.daggerhiltplayground.util.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel
@ViewModelInject constructor(
    private val repository: MainRepository,
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val postData: MutableLiveData<DataState<List<Posts>>> =
        MutableLiveData<DataState<List<Posts>>>()
    val dataState: LiveData<DataState<List<Posts>>> get() = postData

    fun setStateEvents(mainStateEvents: MainStateEvents) {
        viewModelScope.launch {
            when (mainStateEvents) {
                is MainStateEvents.BlogEvents -> {
                    repository.getComments().onEach {
                        postData.value = it
                    }.launchIn(viewModelScope)


                }
                is MainStateEvents.None -> {

                }
            }

        }
    }

}

sealed class MainStateEvents {
    object BlogEvents : MainStateEvents()
    object None : MainStateEvents()
}
