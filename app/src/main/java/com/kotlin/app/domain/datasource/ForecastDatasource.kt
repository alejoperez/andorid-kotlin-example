package com.kotlin.app.domain.datasource

import com.kotlin.app.domain.model.Forecast
import com.kotlin.app.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
    fun requestDayForecast(id: Long): Forecast?

}