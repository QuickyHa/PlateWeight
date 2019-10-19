package com.example.plateweight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** called when the user taps the 'Calculate' button **/
    public void sendMessage(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        TextView textView = findViewById(R.id.textView2);

        //closes keypad on button press
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputManager != null;
        inputManager.hideSoftInputFromWindow(textView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);

        int weight = 0;
        if(message.isEmpty()){
            message = "Please enter a valid weight";
        }else {
            weight = Integer.parseInt(message);

            if (weight <= 45) {
                message = "Please enter a weight heavier than the barbell(45lbs)";
            } else if (weight % 5 != 0) {
                message = "Please enter a value divisible by 5";
            } else {
                message = calculate(weight);
            }
        }

        textView.setText(message);
    }

    /** Calculates how many plates of certain weight are needed for each side on a standard
     * 45lb barbell **/
    public String calculate(int weight){
        double side = (double)(weight - 45)/2;
        String result = "";
        int fourtyfives = 0;
        int thirtyfives = 0;
        int twentyfives = 0;
        int tens = 0;
        int fives = 0;
        int twoFives = 0;

        if(side >= 45) {
            fourtyfives = (int) side / 45;
            side = side - (45 * fourtyfives);
            result = fourtyfives + " x 45\n";
        }

        if(side >= 35){
            thirtyfives = (int) side/35;
            side = side - (35 * thirtyfives);
            result += thirtyfives + " x 35\n";
        }

        if(side >= 25){
            twentyfives = (int) side/25;
            side = side - (25 * twentyfives);
            result += twentyfives + " x 25\n";
        }

        if(side >= 10){
            tens = (int) side/10;
            side = side - (10 * tens);
            result += tens + " x 10\n";
        }

        if(side >= 5){
            fives = (int) side/5;
            side = side - (5 * fives);
            result += fives + " x 5\n";
        }

        if(side >= 2.5){
            twoFives = (int) (side/2.5);
            side = side - (2.5 * twoFives);
            result += twoFives + " x 2.5\n";
        }

        if(side != 0.0){
            return "Error, this shouldn't have happened";
        }

        return result;
    }
}

