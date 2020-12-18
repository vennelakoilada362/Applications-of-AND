package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Apssdc","Activity created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Apssdc","Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Apssdc","Activity Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Apssdc","Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Apssdc","Activity stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Apssdc","Activity restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Apssdc","Activity Destroy");
    }
}