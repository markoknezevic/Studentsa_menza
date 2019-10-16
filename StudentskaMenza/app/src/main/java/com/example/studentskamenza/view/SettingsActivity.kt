package com.example.studentskamenza.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.studentskamenza.R
import com.example.studentskamenza.SistemskeOperacije.TimePicker
import com.example.studentskamenza.controller.Broker
import com.example.studentskamenza.controller.Controller
import com.example.studentskamenza.domen.ContextSettings
import com.example.studentskamenza.domen.Settings
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        ContextSettings.getInstanca().setContex(this)
        var settingsView = SettingsView(dorS,dorE,rucS,rucE,vecS,vecE)
        settingsView.setView(Controller.getInstance().settings!!)
    }

    fun saveSettings(view: View){
        Controller.getInstance().settings=makeSettings()
        Broker.saveSettings(Controller.getInstance().settings!!)
        var intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }

    fun dorucakS(view : View){
        TimePicker.time(dorS)
    }

    fun dorucakE(view : View){
        TimePicker.time(dorE)
    }

    fun rucakS(view : View){
        TimePicker.time(rucS)
    }

    fun rucakE(view : View){
        TimePicker.time(rucE)
    }

    fun veceraS(view : View){
        TimePicker.time(vecS)
    }

    fun veceraE(view : View){
        TimePicker.time(vecE)
    }

    fun makeSettings() : Settings{
        val dorS = TimetoInt(dorS.text.toString())
        val dorE = TimetoInt(dorE.text.toString())
        val rucS = TimetoInt(rucS.text.toString())
        val rucE = TimetoInt(rucE.text.toString())
        val vecS = TimetoInt(vecS.text.toString())
        val vecE = TimetoInt(vecE.text.toString())

        return Settings(dorS,dorE,rucS,rucE,vecS,vecE)
    }
    fun TimetoInt(time : String):Int{
        val p = time.split(":")
        val number = (p[0]+p[1]).toInt()
        return number

    }


}
