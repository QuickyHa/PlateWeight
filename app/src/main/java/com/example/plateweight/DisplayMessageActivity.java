package com.example.plateweight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int weight = 0;

        if(message != null) weight = Integer.parseInt(message);

        if(weight % 5 != 0){
            message = "please enter value divisible by 5";
        }else{
            message = calculate(weight);
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

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
            result = fourtyfives + " x 45s\n";
        }

        if(side >= 35){
            thirtyfives = (int) side/35;
            side = side - (35 * thirtyfives);
            result += thirtyfives + " x 35s\n";
        }

        if(side >= 25){
            twentyfives = (int) side/25;
            side = side - (25 * twentyfives);
            result += twentyfives + " x 25s\n";
        }

        if(side >= 10){
            tens = (int) side/10;
            side = side - (10 * tens);
            result += tens + " x 10s\n";
        }

        if(side >= 5){
            fives = (int) side/5;
            side = side - (5 * fives);
            result += fives + " x 5s\n";
        }

        if(side >= 2.5){
            twoFives = (int) (side/2.5);
            side = side - (2.5 * twoFives);
            result += twoFives + " x 2.5s\n";
        }

        if(side != 0.0){
            return "Error, this shouldn't have happened";
        }

        return result;
    }
}
