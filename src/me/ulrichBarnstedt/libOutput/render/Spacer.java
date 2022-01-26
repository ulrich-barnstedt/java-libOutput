package me.ulrichBarnstedt.libOutput.render;

public class Spacer implements Element {
    private int x;
    private int y;
    private Screen boundScreen;

    public Spacer (int xSpace, int ySpace) {
        this.x = xSpace;
        this.y = ySpace;
    }

    public Spacer (int ySpace) {
        this.y = ySpace;
        this.x = 0;
    }

    public void setXSpace (int x) {
        this.x = x;
        if (this.boundScreen != null) this.boundScreen.redraw();
    }

    public void setYSpace (int y) {
        this.y = y;
        if (this.boundScreen != null) this.boundScreen.redraw();
    }

    @Override
    public void render (int x, int y) {}

    @Override
    public int totalWidth () {
        return this.x;
    }

    @Override
    public int totalHeight () {
        return this.y;
    }

    @Override
    public void attachParent (Screen screen) {
        this.boundScreen = screen;
    }
}
