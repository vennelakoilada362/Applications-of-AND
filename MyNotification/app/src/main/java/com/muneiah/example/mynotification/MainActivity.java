package com.muneiah.example.mynotification;

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
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
/*
NotificationManager nm;
NotificationCompat.Builder builder;
PendingIntent pi;
Intent myintent;
*/
OneTimeWorkRequest onetime;
PeriodicWorkRequest repitedtaks;
EditText et1,et2;
String name,password;
SharedPreferences sp;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onetime=new OneTimeWorkRequest.Builder(FirstWork.class).build();
        repitedtaks=new PeriodicWorkRequest.Builder(ReaptedWork.class,15, TimeUnit.MINUTES).build();
        /*call the id's*/
        et1=findViewById(R.id.editTextTextPersonName);
        et2=findViewById(R.id.editTextTextPersonName2);
        sp=getSharedPreferences("muni",MODE_PRIVATE);
       /* myintent=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,2323,myintent,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createChannel();*/
    }

   /* private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel("My_id","Muni",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nm.createNotificationChannel(nc);
        }
    }*/

    public void showNotification(View view) {
        WorkManager.getInstance(this).enqueue(onetime);
        WorkManager.getInstance(this).enqueue(repitedtaks);
       /* builder=new NotificationCompat.Builder(this,"My_id");
        builder.setContentTitle("This is My Notification");
        builder.setContentText("Hello there this is my own notification copy rightshave only for me..!");
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        nm.notify(1234,builder.build());*/
        /*name=et1.getText().toString();
        password=et2.getText().toString();
        name=et1.getText().toString();
        password=et2.getText().toString();
        editor.putString("n",name);
        editor.putString("p",password);
        editor.apply();*/

    }

    @Override
    protected void onPause() {
        super.onPause();
        editor=sp.edit();
        name=et1.getText().toString();
        password=et2.getText().toString();
        editor.putString("n",name);
        editor.putString("p",password);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String s=sp.getString("n","");
        String ss=sp.getString("p","");
        et1.setText(s);
        et2.setText(ss);
    }
}