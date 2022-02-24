package com.codingwithmitch.daggerhiltplayground

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.codingwithmitch.daggerhiltplayground.model.Posts
import com.codingwithmitch.daggerhiltplayground.ui.MainStateEvents
import com.codingwithmitch.daggerhiltplayground.ui.MainViewModel
import com.codingwithmitch.daggerhiltplayground.util.DataState
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG: String = "AppDebug"
    val viewmodel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setObserver()
        viewmodel.setStateEvents(MainStateEvents.BlogEvents)


    }

    private fun setObserver() {
        viewmodel.dataState.observe(this, androidx.lifecycle.Observer {


            when (it) {
                is DataState.Loading -> {
                    Log.e(TAG, "setObserver Loading")
                }
                is DataState.OnSuccess<List<Posts>> -> {
                    Log.e(TAG, "setObserver OnSuccess" + it.data.toString())

                }

                is DataState.onFailure -> {
                    Log.e(TAG, "setObserver OnSuccess" + it.exception)
                }
            }
        }

        )
    }


}



















