package com.kotlin.app.domain.commands

import com.kotlin.app.domain.datasource.ForecastProvider
import com.kotlin.app.domain.model.ForecastList

class RequestForecastCommand(
        val zipCode: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}