package com.mintaxis.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MinTaxisApplication : Application() {
    
    companion object {
        const val NOTIFICATION_CHANNEL_ID = "mintaxis_notifications"
        const val RIDE_UPDATES_CHANNEL_ID = "ride_updates"
        const val EMERGENCY_CHANNEL_ID = "emergency"
    }
    
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }
    
    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NotificationManager::class.java)
            
            // General notifications channel
            val generalChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "MIN Taxis Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "General notifications from MIN Taxis"
                enableVibration(true)
            }
            
            // Ride updates channel
            val rideChannel = NotificationChannel(
                RIDE_UPDATES_CHANNEL_ID,
                "Ride Updates",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Updates about your current ride"
                enableVibration(true)
            }
            
            // Emergency channel
            val emergencyChannel = NotificationChannel(
                EMERGENCY_CHANNEL_ID,
                "Emergency Alerts",
                NotificationManager.IMPORTANCE_MAX
            ).apply {
                description = "Emergency alerts and notifications"
                enableVibration(true)
                enableLights(true)
            }
            
            notificationManager.createNotificationChannel(generalChannel)
            notificationManager.createNotificationChannel(rideChannel)
            notificationManager.createNotificationChannel(emergencyChannel)
        }
    }
}
