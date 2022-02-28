package com.codingwithmitch.daggerhiltplayground

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
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
    private lateinit var progessBar:ProgressBar
    private lateinit var tvGetData:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        clickListener()
        setObserver()


    }

    private fun initViews() {
        tvGetData=findViewById(R.id.tv_getdata)
        progessBar=findViewById(R.id.progress_bar)
    }

    private fun clickListener() {
        tvGetData.setOnClickListener {
            viewmodel.setStateEvents(MainStateEvents.BlogEvents)

        }
    }

    private fun setObserver() {
        viewmodel.dataState.observe(this, androidx.lifecycle.Observer {


            when (it) {
                is DataState.Loading -> {
                    progessBar.visibility=View.VISIBLE
                    Log.e(TAG, "setObserver Loading")
                }
                is DataState.OnSuccess<List<Posts>> -> {
                    progessBar.visibility=View.GONE
                    tvGetData.append(it.data.toString())
                    Log.e(TAG, "setObserver OnSuccess" + it.data.toString())

                }

                is DataState.onFailure -> {
                    progessBar.visibility=View.GONE
                    Log.e(TAG, "setObserver onFailure" + it.exception.message)
                }
            }
        }

        )
    }


}



















