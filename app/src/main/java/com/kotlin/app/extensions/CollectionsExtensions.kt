package com.kotlin.app.extensions

/**
 * Created by alejo on 2017-06-30.
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()