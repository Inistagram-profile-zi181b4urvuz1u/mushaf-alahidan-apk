package com.adan.alahidan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val prefs = context.getSharedPreferences("adan_prefs", Context.MODE_PRIVATE)
        val json = prefs.getString("alarms_json", null) ?: return
        MainActivity.AndroidBridge.scheduleFromJson(context, json)
    }
}
