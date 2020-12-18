package com.muneiah.example.ournotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static android.content.Context.NOTIFICATION_SERVICE;

public class SecondWork extends Worker {
    NotificationManager nm;
    NotificationCompat.Builder builder;
    public static final int NOTIFICATION_ID=566654564;
    public static final String CHANNEL_ID="mychannel";
    PendingIntent pi;
    Intent i;


    public SecondWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        i=new Intent(getApplicationContext(),MainActivity.class);
        pi=PendingIntent.getActivity(getApplicationContext(),NOTIFICATION_ID,i,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        createChannel();
        showNotification();
        return Result.success();
    }
    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel(CHANNEL_ID,"apssdc",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }
    }
    public void showNotification(){
        builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setContentText("This is our Ripeated work Notification..!");
        builder.setContentTitle("My Notification");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_baseline_reply_24,"Reply",pi);
        nm.notify(NOTIFICATION_ID,builder.build());
    }
}
