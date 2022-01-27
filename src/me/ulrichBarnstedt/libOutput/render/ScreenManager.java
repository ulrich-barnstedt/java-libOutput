package me.ulrichBarnstedt.libOutput.render;

import me.ulrichBarnstedt.libOutput.terminal.Cursor;

import java.util.HashMap;

/**
 * Automatically manage screens
 * @see Screen
 */
public class ScreenManager {
    private HashMap<String, Screen> pages;
    private String selected;

    public ScreenManager() {
        this.pages = new HashMap<>();
    }

    /**
     * Load this screen
     * @param key Key with which the screen was registered
     * @return Instance for chaining
     */
    public ScreenManager open (String key) {
        if (!pages.containsKey(key)) {
            Cursor.toPos(0, 0).p();
            System.err.print("Invalid key " + key + ".");

            System.exit(1);
        }

        this.selected = key;
        this.pages.get(key).redraw();

        return this;
    }

    /**
     * Add a screen
     * @param key Key to register the screen under
     * @param screen Screen to register
     * @return Instance for chaining
     */
    public ScreenManager addScreen (String key, Screen screen) {
        this.pages.put(key, screen);
        return this;
    }

    /**
     * Get the currently open screen
     * @return
     */
    public String getSelected () {
        return this.selected;
    }
}
