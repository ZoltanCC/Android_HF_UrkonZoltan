package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import kotlin.jvm.internal.Lambda;

public class MainActivity extends AppCompatActivity {

    private CalculatorController controller;
    private static MainActivity myself;
    public static MainActivity getInstance() {
        return myself;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // expressionField
        TextView expressionField = findViewById(R.id.expressionField);
        // mainText
        EditText mainText = findViewById(R.id.mainText);
        // Disable focus
        mainText.setFocusable(false);
        // ArrayList containing all Buttons
        ArrayList<Button> numButtons = new ArrayList<Button>();
        // numerical
        numButtons.add(findViewById(R.id.btn_0));
        numButtons.add(findViewById(R.id.btn_1));
        numButtons.add(findViewById(R.id.btn_2));
        numButtons.add(findViewById(R.id.btn_3));
        numButtons.add(findViewById(R.id.btn_4));
        numButtons.add(findViewById(R.id.btn_5));
        numButtons.add(findViewById(R.id.btn_6));
        numButtons.add(findViewById(R.id.btn_7));
        numButtons.add(findViewById(R.id.btn_8));
        numButtons.add(findViewById(R.id.btn_9));
        // decimal separator
        numButtons.add(findViewById(R.id.btn_DEC));
        // operational
        numButtons.add(findViewById(R.id.btn_ADD));
        numButtons.add(findViewById(R.id.btn_DIV));
        numButtons.add(findViewById(R.id.btn_MINUS));
        numButtons.add(findViewById(R.id.btn_MULT));
        numButtons.add(findViewById(R.id.btn_PERC));
        // EQUAL
        numButtons.add(findViewById(R.id.btn_EQ));
        // DELETE
        numButtons.add(findViewById(R.id.btn_DEL));
        // CLEAR
        numButtons.add(findViewById(R.id.btn_C));
        // Create an instance of CalculatorController
        this.controller = new CalculatorController(numButtons, mainText, expressionField);
        myself = this;
    }

}