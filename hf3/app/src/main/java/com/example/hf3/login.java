package com.example.hf3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button lbtn = findViewById(R.id.login_button);
        Button homebtn = findViewById(R.id.home_button);
        Button signupbtn = findViewById(R.id.signup_button);

        lbtn.setOnClickListener((View b) -> { this.showTableLayout(b); });
        homebtn.setOnClickListener((View b) -> { this.showTableLayout(b); });
        signupbtn.setOnClickListener((View b) -> { this.showTableLayout(b); });
    }

    public void showTableLayout(View v) {
        Log.println(Log.VERBOSE,"custom-log", "megy");
        Intent tableView = new Intent(getApplicationContext(), TableActivity.class);
        startActivity(tableView);
    }

}