package com.kawashirosoftware.JellyLEDControl;

import java.io.DataOutputStream;
import java.io.IOException;

public class LEDUtils {
    public static final String LED_PATH = "/sys/bus/platform/devices/lampbelt_leds/driver/lampbelt_leds_duty";
    public static final String LED_PATH_MODE = "/sys/bus/platform/devices/lampbelt_leds/driver/lampbelt_leds_mode";

    public static void writeToPath(String path, int value) {
        new Thread(() -> {
            try {
                Process process = Runtime.getRuntime().exec("su");
                DataOutputStream outputStream = new DataOutputStream(process.getOutputStream());

                String command = "echo " + value + " > " + path + "\n";
                outputStream.writeBytes(command);
                outputStream.flush();

                outputStream.writeBytes("exit\n");
                outputStream.flush();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
