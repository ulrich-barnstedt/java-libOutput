package me.ulrichBarnstedt.libOutput.render;

import java.util.HashMap;

public class ScreenManager {
    private HashMap<String, Screen> pages;
    private String selected;

    public ScreenManager() {
        this.pages = new HashMap<>();
    }

    public ScreenManager open (String key) {
        this.selected = key;
        this.pages.get(key).redraw();

        return this;
    }

    public ScreenManager addPage (String key, Screen screen) {
        this.pages.put(key, screen);
        return this;
    }

    public String getSelected () {
        return this.selected;
    }
}
