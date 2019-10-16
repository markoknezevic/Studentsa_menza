package com.example.studentskamenza.domen

import android.content.Context

class ContextSettings {
    var context : Context?= null
    companion object{
        var instance : ContextMain ?= null
        fun getInstanca() : ContextMain{
            if(instance == null)
                instance = ContextMain()
            return instance!!
        }
    }

    fun setContex(context: Context){
        this.context = context
    }
}