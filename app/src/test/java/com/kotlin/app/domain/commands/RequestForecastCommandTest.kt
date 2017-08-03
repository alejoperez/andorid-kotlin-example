package com.kotlin.app.domain.commands

import com.kotlin.app.domain.datasource.ForecastProvider
import org.junit.Assert.*

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RequestDayForecastCommandTest {

    @Test
    fun testProviderIsCalled() {
        val forecastProvider = mock(ForecastProvider::class.java)
        val command = RequestDayForecastCommand(2, forecastProvider)

        command.execute()

        verify(forecastProvider).requestForecast(2)
    }
}