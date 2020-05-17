package com.example.sensorcheck

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        /* val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
         Log.v("Total sensors",""+deviceSensors.size)
         deviceSensors.forEach{
             Log.v("Sensor name",""+it)
         }*/
        val sensorlist = getlist()
        rec.adapter = RAdapter(sensorlist)
        rec.layoutManager = LinearLayoutManager(this)
        rec.setHasFixedSize(true)


    }
    fun getlist(): List<RItem> {

        val list = ArrayList<RItem>()
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        Log.v("Total sensors", "" + deviceSensors.size)
        deviceSensors.forEach {
            Log.v("Sensor name", "" + it.name)
            val item = RItem(it.name, "Details: $it")
            list += item
        }
        return list
    }
}

