package com.kotlin.app.data

data class ForecastResult(val city : City, val cod : String, val message : Double, val cnt : Int, val list : List<Forecast>)

data class City(val id : Long, val name : String, val coord : Coordinates, val country : String, val population : Long)

data class Coordinates(val lon : Double, val lat : Double)

data class Forecast(val dt: Long, val temp : Temperature, val pressure : Double, val humidity : Int, val weather : List<Weather>, val speed : Float, val deg : Int, val clouds : Int)

data class Temperature(val day : Float, val min : Float, val max : Float, val night : Float, val eve : Float, val morn : Float)

data class Weather(val id : Long, val main:String, val description : String, val icon : String)