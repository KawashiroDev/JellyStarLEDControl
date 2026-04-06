package com.kawashirosoftware.JellyLEDControl;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ensure the title bar is visible
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }



        // Volume SeekBar setup
        SeekBar volumeSeekBar = findViewById(R.id.BrightnessSeekBar);
        volumeSeekBar.setMax(255);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int realValue = progress + 1;
                writebrightness(realValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



        // off Button
        Button illuminateButton = findViewById(R.id.LightOffButton);
        illuminateButton.setOnClickListener(v -> writebrightness(0));

        // Mode 2 Button
        Button mode2Button = findViewById(R.id.Mode2Button);
        mode2Button.setOnClickListener(v -> writeMode(2));
    }

    private void writeMode(int value) {
        LEDUtils.writeToPath(LEDUtils.LED_PATH_MODE, value);
    }

    private void writebrightness(int value) {
        LEDUtils.writeToPath(LEDUtils.LED_PATH, value);
    }





}
