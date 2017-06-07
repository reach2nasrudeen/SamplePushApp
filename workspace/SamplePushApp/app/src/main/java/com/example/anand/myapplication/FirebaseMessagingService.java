package com.example.anand.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService{
    Context mContext;
    String TAG = FirebaseMessagingService.class.getSimpleName();
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        showNotification(remoteMessage.getNotification().getBody());
    }

    private void showNotification(String message) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("body",message);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentTitle(mContext.getString(R.string.app_name))
                .setContentText(message)
                .setContentIntent(pendingIntent);

            builder.setSound(defaultSoundUri);

            builder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });

        NotificationManager manager = (NotificationManager)this. getSystemService(NOTIFICATION_SERVICE);
        manager.notify((int) System.currentTimeMillis(), builder.build());

    }
}
