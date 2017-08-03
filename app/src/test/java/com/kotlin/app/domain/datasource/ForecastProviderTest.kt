package com.kotlin.app.domain.datasource

import com.kotlin.app.domain.model.Forecast
import com.kotlin.app.domain.model.ForecastList
import org.junit.Assert.*
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.mockito.Mockito.*

class ForecastProviderTest {

    @Test fun testDataSourceReturnsValue() {
        val ds = mock(ForecastDataSource::class.java)
        `when`(ds.requestDayForecast(0)).then { Forecast(0, 0, "desc", 20, 0, "url") }

        val provider = ForecastProvider(listOf(ds))
        assertNotNull(provider.requestForecast(0))
    }

    @Test fun emptyDatabaseReturnsServerValue() {
        val db = mock(ForecastDataSource::class.java)
        val server = mock(ForecastDataSource::class.java)
        `when`(server.requestForecastByZipCode(any(Long::class.java), any(Long::class.java)))
                .then { ForecastList(0, "city", "country", listOf()) }

        val provider = ForecastProvider(listOf(db, server))
        assertNotNull(provider.requestByZipCode(0, 0))
    }
}