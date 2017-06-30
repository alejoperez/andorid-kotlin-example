package com.kotlin.app.extensions

/**
 * Created by alejo on 2017-06-30.
 */
import android.content.Context
import android.view.View

val View.ctx: Context
    get() = context