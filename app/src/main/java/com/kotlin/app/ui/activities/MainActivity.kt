package com.kotlin.app.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.kotlin.app.ui.adapters.ForecastListAdapter
import com.kotlin.app.R
import com.kotlin.app.domain.commands.RequestForecastCommand
import com.kotlin.app.extensions.DelegatesExt
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), ToolbarManager {

    val zipCode: Long by DelegatesExt.preference(this, SettingsActivity.ZIP_CODE, SettingsActivity.DEFAULT_ZIP)

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() = doAsync {
        val result = RequestForecastCommand(zipCode).execute()
        uiThread {
            val adapter = ForecastListAdapter(result) {
                startActivity<DetailActivity>(DetailActivity.ID to it.id,
                        DetailActivity.CITY_NAME to result.city)
            }
            forecastList.adapter = adapter
            toolbarTitle = "${result.city} (${result.country})"
        }
    }
}