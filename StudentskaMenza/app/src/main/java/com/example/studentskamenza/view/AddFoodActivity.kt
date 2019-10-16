package com.example.studentskamenza.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.studentskamenza.R
import com.example.studentskamenza.controller.Broker
import com.example.studentskamenza.controller.Controller
import com.example.studentskamenza.domen.Food
import kotlinx.android.synthetic.main.activity_add_food.*

class AddFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
    }

    fun uplati(view: View){
        Controller.getInstance().food!!.add(makeFood())
        Broker.saveFood(Controller.getInstance().food!!)
        startIntent()
    }


    fun makeFood():Food{
        val dorucak = dorucakValue.text.toString().toInt()
        val rucak = rucakValue.text.toString().toInt()
        val vecera = veceraValue.text.toString().toInt()
        return Food(dorucak,rucak,vecera)
    }

    fun startIntent(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
