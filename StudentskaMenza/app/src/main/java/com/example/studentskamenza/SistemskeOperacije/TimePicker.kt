package com.example.studentskamenza.SistemskeOperacije

import android.app.TimePickerDialog
import android.widget.TextView
import com.example.studentskamenza.domen.ContextSettings
import java.util.*

class TimePicker {
    companion object{
        fun time(textView : TextView){
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR)
            val minutes = c.get(Calendar.MINUTE)
            val t = TimePickerDialog(ContextSettings.getInstanca().context, TimePickerDialog.OnTimeSetListener(function = { view, h, mm ->
                var m = mm.toString()
                if(mm<10)
                    m=("0"+m)
                textView.text = h.toString()+":"+m

            }),hour,minutes,true)
            t.show()

        }
    }
}