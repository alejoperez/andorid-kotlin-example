package com.kotlin.app.domain.commands

/**
 * Created by Alejo on 2017-06-26.
 */
interface Command<out T> {
    fun execute(): T
}