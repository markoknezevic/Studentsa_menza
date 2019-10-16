package com.example.studentskamenza.SistemskeOperacije

import android.app.AlertDialog
import com.example.studentskamenza.controller.Controller
import com.example.studentskamenza.domen.ContextMain

class AlertDialog {
    companion object{
        fun alert(){
            val alert = AlertDialog.Builder(ContextMain.getInstanca().context)
            alert.setMessage("Uzimas li veceru?")
            alert.setTitle("Vecera")

            alert.setPositiveButton("Da"){dialog, i ->
                Controller.getInstance().food!!.vecera-=1
                Controller.getInstance().setView()
            }
            alert.setNegativeButton("Ne"){dialog, i ->
            }

            alert.show()
        }
    }
}