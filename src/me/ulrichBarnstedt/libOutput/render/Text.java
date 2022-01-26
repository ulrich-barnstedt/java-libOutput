package me.ulrichBarnstedt.libOutput.render;

import me.ulrichBarnstedt.libOutput.color.AsciiList;
import me.ulrichBarnstedt.libOutput.terminal.Cursor;

/**
 * Single, renderable line of text
 */
public class Text extends Element {
    private String content;
    private Screen boundScreen;
    private String color = "";

    /**
     * @param content String to display
     */
    public Text (String content) {
        this.content = content;
    }

    /**
     * Set the string to display
     * @param content
     * @return Instance for chaining
     */
    public Text setContent (String content) {
        this.content = content;
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    /**
     * Set the display color
     * @param color The color as a string (normally an escape code, see COLOR part of library for helper classes which support these)
     * @return Instance for chaining
     */
    public Text setColor (String color) {
        this.color = color;
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    /**
     * Get displayed string
     * @return
     */
    public String getContent () {
        return content;
    }

    @Override
    void render (int x, int y) {
        System.out.print(Cursor.toPos(x, y) + this.color + this.content + AsciiList.RESET);
    }

    @Override
    int totalWidth () {
        return this.content.length();
    }

    @Override
    int totalHeight () {
        return 1;
    }

    @Override
    void attachParent (Screen screen) {
        this.boundScreen = screen;
    }
}
