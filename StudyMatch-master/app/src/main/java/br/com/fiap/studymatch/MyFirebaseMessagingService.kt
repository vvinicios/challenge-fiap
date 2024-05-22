package br.com.fiap.studymatch


import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import br.com.fiap.studymatch.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        getFirebaseMessage(message.getNotification()?.getTitle(),
            message.getNotification()?.getBody()
        )
    }

    fun getFirebaseMessage(title: String?, body: String?) {

        NotificationCompat.Builder(this, "notify")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(body)

        val managerCompat : NotificationManagerCompat  = NotificationManagerCompat.from(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        managerCompat.notify(1, NotificationCompat.Builder(this, "notify").build())
    }
}