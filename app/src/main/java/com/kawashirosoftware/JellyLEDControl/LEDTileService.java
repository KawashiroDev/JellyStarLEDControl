package com.kawashirosoftware.JellyLEDControl;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class LEDTileService extends TileService {

    @Override
    public void onClick() {
        super.onClick();
        Tile tile = getQsTile();
        if (tile == null) return;

        int newState;
        if (tile.getState() == Tile.STATE_ACTIVE) {
            newState = Tile.STATE_INACTIVE;
            LEDUtils.writeToPath(LEDUtils.LED_PATH, 0);
        } else {
            newState = Tile.STATE_ACTIVE;
            LEDUtils.writeToPath(LEDUtils.LED_PATH, 255);
        }

        tile.setState(newState);
        tile.updateTile();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        // We don't have a reliable way to read the current state from sysfs easily here without root 
        // and it might be slow. For now, we'll let it persist the last known state or default to inactive.
    }
}
