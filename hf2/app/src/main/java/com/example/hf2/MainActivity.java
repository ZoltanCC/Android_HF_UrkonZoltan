package com.example.hf2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


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
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

    }

    public void onButtonClick(View e) {
        Intent newIntent = new Intent(getApplicationContext(), Activity2.class);
        startActivity(newIntent);

    }
}