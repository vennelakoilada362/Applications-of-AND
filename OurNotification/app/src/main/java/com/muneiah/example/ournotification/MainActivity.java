package com.muneiah.example.ournotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
/*NotificationManager nm;
NotificationCompat.Builder builder;
public static final int NOTIFICATION_ID=566654564;
public static final String CHANNEL_ID="mychannel";
PendingIntent pi;
Intent i;*/
OneTimeWorkRequest onetime;
PeriodicWorkRequest secondtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onetime=new OneTimeWorkRequest.Builder(FirstWork.class).build();
        secondtime=new PeriodicWorkRequest.Builder(SecondWork.class,15, TimeUnit.MINUTES).build();
       /* i=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,NOTIFICATION_ID,i,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createChannel();*/
    }
   /* private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel(CHANNEL_ID,"apssdc",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }
    }*/
    public void showNotification(View view) {
        WorkManager.getInstance(this).enqueue(onetime);
        WorkManager.getInstance(this).enqueue(secondtime);
       /* builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setContentText("This is our own Notification..!");
        builder.setContentTitle("My Notification");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_baseline_reply_24,"Reply",pi);
        nm.notify(NOTIFICATION_ID,builder.build());*/
    }
}