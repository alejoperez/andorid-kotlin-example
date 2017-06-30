package com.kotlin.app.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.app.ui.adapters.ForecastListAdapter
import com.kotlin.app.R
import com.kotlin.app.data.db.ForecastDb
import com.kotlin.app.domain.commands.RequestForecastCommand
import com.kotlin.app.domain.model.ForecastList
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val ZIP_CODE : Long = 94043


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastRecyclerView.layoutManager = LinearLayoutManager(this)

        val localForecast : ForecastList? = ForecastDb().requestForecastByZipCode(ZIP_CODE,Calendar.getInstance().timeInMillis - TimeUnit.DAYS.toMillis(1))

        if (localForecast != null) {
            val adapter = ForecastListAdapter(localForecast, { toast(it.description) })
            forecastRecyclerView.adapter = adapter
        }


        doAsync {
            val result = RequestForecastCommand(ZIP_CODE).execute()
            uiThread {
                val adapter = ForecastListAdapter(result, { toast(it.description) })
                forecastRecyclerView.adapter = adapter
            }
        }
    }
}