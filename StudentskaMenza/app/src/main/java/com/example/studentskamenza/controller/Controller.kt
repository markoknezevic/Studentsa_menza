package com.example.studentskamenza.controller

import android.widget.TextView
import android.widget.Toast
import com.example.studentskamenza.SistemskeOperacije.AlertDialog
import com.example.studentskamenza.domen.ContextMain
import com.example.studentskamenza.domen.Food
import com.example.studentskamenza.domen.Settings
import com.example.studentskamenza.view.FoodView
import java.text.SimpleDateFormat
import java.util.*

class Controller {

    private var foodView : FoodView ?= null
    var food : Food?= null
    var settings : Settings ?= null

    companion object {
        private var instance: Controller? = null
        public fun getInstance() : Controller{
            if(instance == null)
                instance= Controller()
            return instance!!
        }

    }

    init {
        foodView = FoodView()
        food = Broker.getFood()
        settings = Broker.getSettings()
    }

    fun setView(){
        foodView!!.setView(food!!)
    }

    fun initView(dorView : TextView,rucView : TextView,vecView : TextView){
        foodView!!.initView(dorView,rucView,vecView)
        setView()
    }

    fun execute(){
        val sdf = SimpleDateFormat("HHmm")
        val curent = sdf.format(Date()).toInt()

        val sdf2 = SimpleDateFormat("EEE")
        val day = sdf2.format(Date()).toString()

        if(curent < settings!!.dorucakE && curent > settings!!.dorucakS && food!!.dorucak > 0){
            food!!.dorucak-=1
        }else if(curent < settings!!.rucakE && curent > settings!!.rucakS && food!!.rucak > 0){
            food!!.rucak-=1
            if(day == "Sat" || day == "Sun"){
                AlertDialog.alert()
            }
        }else if(curent < settings!!.veceraE && curent > settings!!.veceraS && food!!.vecera > 0 && day != "Sat" && day != "Sun"){
            food!!.vecera-=1
        }else{
            Toast.makeText(ContextMain.getInstanca().context,"Greska",Toast.LENGTH_LONG).show()
        }
        Broker.saveFood(food!!)
        setView()
    }

    fun deleteAll(){
        food= Food(0,0,0)
        setView()
        Broker.deleteAll()
    }


}