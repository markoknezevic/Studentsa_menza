package com.example.studentskamenza.controller

import android.content.Context
import com.example.studentskamenza.domen.ContextMain
import com.example.studentskamenza.domen.Food
import com.example.studentskamenza.domen.Settings

class Broker{
    companion object{
        fun saveFood(food: Food){
            val sharedPreferences = ContextMain.getInstanca().context!!.getSharedPreferences("com.example.studentskamenza",
                Context.MODE_PRIVATE)

            sharedPreferences.edit().putInt("dorucak",food.dorucak).apply()
            sharedPreferences.edit().putInt("rucak",food.rucak).apply()
            sharedPreferences.edit().putInt("vecera",food.vecera).apply()
        }

        fun getFood():Food{
            val sharedPreferences = ContextMain.getInstanca().context!!.getSharedPreferences("com.example.studentskamenza",
                Context.MODE_PRIVATE)

            val dorucak = sharedPreferences.getInt("dorucak",0)
            val rucak = sharedPreferences.getInt("rucak",0)
            val vecera = sharedPreferences.getInt("vecera",0)

            return Food(dorucak,rucak,vecera)
        }

        fun getSettings():Settings{
            val sharedPreferences = ContextMain.getInstanca().context!!.getSharedPreferences("com.example.studentskamenza",
                Context.MODE_PRIVATE)

            val dS = sharedPreferences.getInt("dS",730)
            val dE = sharedPreferences.getInt("dE",1030)
            val rS = sharedPreferences.getInt("rS",1200)
            val rE = sharedPreferences.getInt("rE",1500)
            val vS = sharedPreferences.getInt("vS",1730)
            val vE = sharedPreferences.getInt("vE",1930)

            return Settings(dS,dE,rS,rE,vS,vE)
        }

        fun saveSettings(settings: Settings){
            val sharedPreferences = ContextMain.getInstanca().context!!.getSharedPreferences("com.example.studentskamenza",
                Context.MODE_PRIVATE)

            sharedPreferences.edit().putInt("dS",settings.dorucakS).apply()
            sharedPreferences.edit().putInt("dE",settings.dorucakE).apply()
            sharedPreferences.edit().putInt("rS",settings.rucakS).apply()
            sharedPreferences.edit().putInt("rE",settings.rucakE).apply()
            sharedPreferences.edit().putInt("vS",settings.veceraS).apply()
            sharedPreferences.edit().putInt("vE",settings.veceraE).apply()

        }

        fun deleteAll(){


            val sharedPreferences = ContextMain.getInstanca().context!!.getSharedPreferences("com.example.studentskamenza",
                Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt("dorucak",0).apply()
            sharedPreferences.edit().putInt("rucak",0).apply()
            sharedPreferences.edit().putInt("vecera",0).apply()
        }
    }
}