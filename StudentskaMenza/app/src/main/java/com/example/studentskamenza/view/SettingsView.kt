package com.example.studentskamenza.view

import android.widget.TextView
import com.example.studentskamenza.domen.Settings

class SettingsView (var dorS: TextView,
                    var dorE: TextView,
                    var rucS: TextView,
                    var rucE: TextView,
                    var vecS: TextView,
                    var vecE: TextView){
    fun setView(settings : Settings){
        this.dorS.text = IntToTime(settings.dorucakS)
        this.dorE.text = IntToTime(settings.dorucakE)
        this.rucS.text = IntToTime(settings.rucakS)
        this.rucE.text = IntToTime(settings.rucakE)
        this.vecS.text = IntToTime(settings.veceraS)
        this.vecE.text = IntToTime(settings.veceraE)
    }

    fun IntToTime(time : Int):String{
        val result = StringBuilder(time.toString())
        if(time < 1000)
            result.insert(1,":")
        else
            result.insert(2,":")

        return result.toString()
    }
}