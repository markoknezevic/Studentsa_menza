package com.example.studentskamenza.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.studentskamenza.R
import com.example.studentskamenza.controller.Controller
import com.example.studentskamenza.domen.ContextMain
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ContextMain.getInstanca().setContex(this)
        Controller.getInstance().initView(dorucakView,rucakView,veceraView)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuinflater = menuInflater
        menuinflater.inflate(R.menu.add_food,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == R.id.add){
            val intent = Intent(applicationContext,AddFoodActivity::class.java)
            startActivity(intent)
        }
        if(item.itemId == R.id.deleteall){
            Controller.getInstance().deleteAll()
        }
        if(item.itemId == R.id.settings){
            val intent = Intent(applicationContext,SettingsActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    fun execute(view: View){
        Controller.getInstance().execute()
    }


}
