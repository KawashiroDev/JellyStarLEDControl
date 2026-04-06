# JellyStarLEDControl

An app that allows you to control the rear LED ring on a Unihertz Jelly Star on LineageOS


Also adds a quick settings tile for turning the LED ring on/off

Requires root access

<p float="left">

<img src="https://github.com/KawashiroDev/JellyStarLEDControl/raw/main/screenshots/Screenshot_20260406-172754_Jelly%20LED%20Control.png" width="250">

<img src="https://github.com/KawashiroDev/JellyStarLEDControl/raw/main/screenshots/Screenshot_20260406-172913_Jelly%20LED%20Control.png" width="250">

</p>


## What this does:

Changing the brightness value writes 1-255 to /sys/bus/platform/devices/lampbelt_leds/driver/lampbelt_leds_duty

Writing a 0 to this turns off the lights

The quick tile toggles between 255 and 0 to lampbelt_leds_duty

The "mode 2" button writes a 2 to /sys/bus/platform/devices/lampbelt_leds/driver/lampbelt_leds_mode which causes the lights to flash in a pattern

Values 0-6 are valid for lampbelt_leds_mode but 2 is the best one


## Notes:
Tested on a Unihertz Jelly Star running AndyYan's LineageOS GSI - lineage-21.0-20260324-UNOFFICIAL-arm64_bvN

This app does nothing special, You can do what this app does with a root ADB shell or Termux

As this app writes direct values to the LED brightness controls this may cause overheating/battery drain if the LEDs are left on

The rear LED ring will automatically turn off when the screen turns off

App is vibe coded
