package com.muneiah.example.mynotification;

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

public class ReaptedWork extends Worker {
    NotificationManager nm;
    NotificationCompat.Builder builder;
    PendingIntent pi;
    Intent myintent;

    public ReaptedWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        myintent=new Intent(getApplicationContext(),MainActivity.class);
        pi=PendingIntent.getActivity(getApplicationContext(),2323,myintent,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        createChannel();
        showNotification();

        return Result.success();
    }

    private void showNotification() {
        builder=new NotificationCompat.Builder(getApplicationContext(),"My_id");
        builder.setContentTitle("This is My Notification");
        builder.setContentText("Ripeated time Work Notification");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        nm.notify(1234,builder.build());
    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel("My_id","Muni",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nm.createNotificationChannel(nc);
        }
    }
}
