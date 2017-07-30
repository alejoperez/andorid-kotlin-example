package com.kotlin.app.extensions

import java.text.DateFormat
import java.util.*

/**
 * Created by Alejo on 2017-07-30.
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}