package com.kotlin.app.domain.commands

import com.kotlin.app.domain.datasource.ForecastProvider
import com.kotlin.app.domain.model.Forecast


class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}
