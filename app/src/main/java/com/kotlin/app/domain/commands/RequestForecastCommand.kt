package com.kotlin.app.domain.commands

import com.kotlin.app.ForecastRequest
import com.kotlin.app.domain.mappers.ForecastDataMapper
import com.kotlin.app.domain.model.ForecastList

/**
 * Created by Alejo on 2017-06-26.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastResult = ForecastRequest(zipCode).execute()
        return ForecastDataMapper().convertFromDataModel(forecastResult)
    }
}