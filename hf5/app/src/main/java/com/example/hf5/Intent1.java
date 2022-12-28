package com.example.hf5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Intent1 extends AppCompatActivity {

    private EditText firstName,secondName;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);

        firstName = findViewById(R.id.editTextTextPersonName);
        secondName = findViewById(R.id.editTextTextPersonName2);
        submitButton = findViewById(R.id.button2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = firstName.getText().toString();
                String lastname = secondName.getText().toString();

                Toast.makeText(Intent1.this,"szia",Toast.LENGTH_SHORT);

                Intent intent = new Intent(Intent1.this,Intent2.class);
                intent.putExtra("firstname", firstname);
                intent.putExtra("lastname", lastname);
                startActivity(intent);

            }
        });

    }
}