package com.example.studentskamenza.view

import android.widget.TextView
import com.example.studentskamenza.domen.Food

class FoodView {
    var dorucakView : TextView ?= null
    var rucakView : TextView ?= null
    var veceraView : TextView ?= null


    fun initView(dorView : TextView,rucView : TextView,vecView : TextView){
        this.dorucakView = dorView
        this.rucakView = rucView
        this.veceraView = vecView
    }
    fun setView(food : Food){
        dorucakView!!.text = "Dorucak: "+food.dorucak.toString()
        rucakView!!.text = "Rucak: "+food.rucak.toString()
        veceraView!!.text = "Vecera: "+food.vecera.toString()
    }

}