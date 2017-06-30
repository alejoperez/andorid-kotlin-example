package com.kotlin.app.ui

import android.app.Application
import com.kotlin.app.extensions.DelegatesExt

/**
 * Created by alejo on 2017-06-30.
 */

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
