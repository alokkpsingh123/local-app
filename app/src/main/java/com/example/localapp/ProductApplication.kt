package com.example.localapp

import android.app.Application
import com.example.localapp.di.ApplicationComponent
import com.example.localapp.di.DaggerApplicationComponent

class ProductApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}