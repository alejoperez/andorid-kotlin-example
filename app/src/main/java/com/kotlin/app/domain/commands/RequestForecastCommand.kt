package com.kotlin.app.domain.commands

import com.kotlin.app.data.db.ForecastDb
import com.kotlin.app.data.server.ForecastRequest
import com.kotlin.app.domain.mappers.ForecastDataMapper
import com.kotlin.app.domain.model.ForecastList

/**
 * Created by Alejo on 2017-06-26.
 */
class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        val result = ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
        ForecastDb().saveForecast(result)
        return result
    }
}