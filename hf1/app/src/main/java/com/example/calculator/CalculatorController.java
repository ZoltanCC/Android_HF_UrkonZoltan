package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalculatorController implements INumberButtonListener {

    private final ArrayList<Button> buttons;
    private final EditText display;
    private final TextView expressionView;
    private String buffer = "";
    private String previousBuffer = "";
    private CalculatorOperation operation;
    private boolean hasResult = false;

    public CalculatorController(ArrayList<Button> buttons, EditText display, TextView expressionView) {
        this.buttons = buttons;
        this.display = display;
        this.expressionView = expressionView;
        this.operation = CalculatorOperation.NONE;
        this.setListeners();
    }

    private void setListeners() {
        this.buttons.forEach(b -> b.setOnClickListener(e -> this.onClick((Button)e)));
    }

    /**
     * Tries to parse String parameter, if string does not contain a number it returns a *null*
     * @param value String (must contain a number otherwise it returns null)
     * @return Integer | null
     */
    public static Integer parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Handles A calculator button click event
     * @param e Event (Button)
     */
    @Override
    public void onClick(Button e) {
        String val = e.getText().toString();
        switch(val) {
            // Arithmetical operations
            case "+":
                if (this.buffer == "" || this.buffer == "-") {
                    return;
                }
                this.operation = CalculatorOperation.ADD;
                this.previousBuffer = this.buffer;
                this.buffer = "";
                expressionView.setText(this.previousBuffer + " + ...");
                display.setText(this.buffer);
                break;
            case "-":
                if (this.buffer == "") {
                    this.buffer = "-";
                }
                else if (this.buffer != "-") {
                    this.operation = CalculatorOperation.SUBSTRACT;
                    this.previousBuffer = this.buffer;
                    this.buffer = "";
                    expressionView.setText(this.previousBuffer + " - ...");
                }
                display.setText(this.buffer);
                break;
            case "X":
                if (this.buffer == "" || this.buffer == "-") {
                    return;
                }
                this.operation = CalculatorOperation.MULTIPLY;
                this.previousBuffer = this.buffer;
                this.buffer = "";
                expressionView.setText(this.previousBuffer + " X ...");
                display.setText(this.buffer);
                break;
            case "/":
                if (this.buffer == "" || this.buffer == "-") {
                    return;
                }
                this.operation = CalculatorOperation.DIVIDE;
                this.previousBuffer = this.buffer;
                this.buffer = "";
                expressionView.setText(this.previousBuffer + " / ...");
                display.setText(this.buffer);
                break;
            case "%":
                if (this.operation == CalculatorOperation.NONE || this.operation == CalculatorOperation.CLEAR || this.operation == CalculatorOperation.DELETE) {
                    this.operation = CalculatorOperation.PERCENTAGE;
                    this.previousBuffer = this.buffer;
                }
                break;
            // Other application operations
            case "C":
                this.operation = CalculatorOperation.CLEAR;
                // Clear buffer and previousBuffer
                this.buffer = "";
                this.previousBuffer = "";
                // Update display
                display.setText(this.buffer);
                expressionView.setText(this.previousBuffer);
                break;
            case "DEL":
                this.operation = CalculatorOperation.DELETE;
                if (this.buffer.length() > 0) {
                    // Delete one character at the end in buffer
                    this.buffer = this.buffer.substring(0, this.buffer.length() - 1);
                    // Update display
                    display.setText(this.buffer);
                }
                break;
            // Equals
            case "=":
                // Only in specific operations
                if (this.operation != CalculatorOperation.NONE && this.operation != CalculatorOperation.DELETE && this.operation != CalculatorOperation.CLEAR && this.buffer != "" && this.previousBuffer != "") {
                    // Handle values as double
                    double buf1, buf2;
                    String expressionString = expressionView.getText().toString();
                    buf1 = Double.parseDouble(this.buffer.replace(",", "."));
                    buf2 = Double.parseDouble(this.previousBuffer.replace(",", "."));
                    // Handle operation
                    if (this.operation == CalculatorOperation.ADD) {
                        this.buffer = buf2 + buf1 + "";
                    }
                    else if (this.operation == CalculatorOperation.SUBSTRACT) {
                        this.buffer = (buf2 - buf1) + "";
                    }
                    else if (this.operation == CalculatorOperation.MULTIPLY) {
                        this.buffer = buf2 * buf1 + "";
                    }
                    else if (this.operation == CalculatorOperation.DIVIDE) {
                        this.buffer = buf2 / buf1 + "";
                    }
                    // Separate the logic[!important]
                    if (this.operation == CalculatorOperation.PERCENTAGE) {
                        this.buffer = buf2 / 100 + "";
                        expressionView.setText(buf2 + " % = " + this.buffer);
                    }
                    else {
                        // Update view
                        expressionView.setText(expressionString.substring(0, expressionString.length() - 3) + buf1 + " = " + this.buffer);
                    }
                    display.setText(this.buffer);
                    this.operation = CalculatorOperation.NONE;
                }
                else {
                    Toast.makeText(MainActivity.getInstance(), "Please select an operation first", Toast.LENGTH_SHORT).show();
                }
                break;
            // Decimal phrase
            case ",":
                if (!this.buffer.contains(val/*","*/)) {
                    // if buffer is empty put a '0' in front of decimal phrase
                    if (this.buffer.length() == 0) {
                        this.buffer += "0" + val;
                    }
                    else {
                        // else simply add ',' at the end
                        this.buffer += val;
                    }
                    // Update display
                    display.setText(this.buffer);
                }
                break;
            // By default it can only be a numeric
            default:
                Integer numVal = CalculatorController.parseInt(val);
                if (numVal != null) {
                    this.buffer += e.getText();
                }
                // no matter what happens always update text from buffer
                display.setText(this.buffer);
                break;
        }
    }
}
