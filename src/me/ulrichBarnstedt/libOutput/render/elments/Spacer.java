package me.ulrichBarnstedt.libOutput.render.elments;

/**
 * Spacing between elements
 */
public class Spacer extends Element {
    private int x;
    private int y;
    private Screen boundScreen;

    /**
     * @param xSpace Spacing on x-axis
     * @param ySpace Spacing on y-axis
     */
    public Spacer (int xSpace, int ySpace) {
        this.x = xSpace;
        this.y = ySpace;
    }

    /**
     * @param ySpace Spacing on y-axis
     */
    public Spacer (int ySpace) {
        this.y = ySpace;
        this.x = 0;
    }

    /**
     * Set x-axis spacing
     * @param x
     */
    public void setXSpace (int x) {
        this.x = x;
        if (this.boundScreen != null) this.boundScreen.redraw();
    }

    /**
     * Set y-axis spacing
     * @param y
     */
    public void setYSpace (int y) {
        this.y = y;
        if (this.boundScreen != null) this.boundScreen.redraw();
    }

    @Override
    void render (int x, int y) {}

    @Override
    int totalWidth () {
        return this.x;
    }

    @Override
    int totalHeight () {
        return this.y;
    }

    @Override
    void attachParent (Screen screen) {
        this.boundScreen = screen;
    }
}
