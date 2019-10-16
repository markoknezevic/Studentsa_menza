package com.example.studentskamenza.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.example.studentskamenza.R
import com.example.studentskamenza.controller.Broker
import com.example.studentskamenza.domen.Food

/**
 * Implementation of App Widget functionality.
 */
class FoodWidget : AppWidgetProvider() {

    var food : Food ?= null

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }

        val views = RemoteViews(context.packageName, R.layout.food_widget)
        //views.setTextViewText(R.id.appwidget_text, widgetText)
        val food = Broker.getFood()
        views.setTextViewText(R.id.dorucakWidgetView,food.dorucak.toString())

    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    companion object {

        internal fun updateAppWidget(
            context: Context, appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {

            //val widgetText = context.getString(R.string.appwidget_text)
            // Construct the RemoteViews object
            val views = RemoteViews(context.packageName, R.layout.food_widget)
            //views.setTextViewText(R.id.appwidget_text, widgetText)
            val food = Broker.getFood()
            views.setTextViewText(R.id.dorucakWidgetView,food.dorucak.toString())


            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

