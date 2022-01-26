package me.ulrichBarnstedt.libOutput.render;

import me.ulrichBarnstedt.libOutput.color.AsciiList;
import me.ulrichBarnstedt.libOutput.terminal.Cursor;

public class Text implements Element {
    private String content;
    private Screen boundScreen;
    private String color = "";

    public Text (String content) {
        this.content = content;
    }

    public Text setContent (String content) {
        this.content = content;
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    public Text setColor (String color) {
        this.color = color;
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    public String getContent () {
        return content;
    }

    @Override
    public void render (int x, int y) {
        System.out.print(Cursor.toPos(x, y) + this.color + this.content + AsciiList.RESET);
    }

    @Override
    public int totalWidth () {
        return this.content.length();
    }

    @Override
    public int totalHeight () {
        return 1;
    }

    @Override
    public void attachParent (Screen screen) {
        this.boundScreen = screen;
    }
}
