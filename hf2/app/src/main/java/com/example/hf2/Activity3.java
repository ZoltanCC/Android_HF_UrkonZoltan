package com.example.hf2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.println(Log.VERBOSE, "log_info", "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.println(Log.VERBOSE, "log_info", "onPause");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.println(Log.VERBOSE, "log_info", "onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.println(Log.VERBOSE, "log_info", "onResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.println(Log.VERBOSE, "log_info", "onDestroy");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }
}