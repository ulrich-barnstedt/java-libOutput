package me.ulrichBarnstedt.libOutput.render.style;

/**
 * Class for representing padding on container-like elements.
 * All setters are chainable.
 */
public class PaddingStyle {
    private int l;
    private int r;
    private int t;
    private int b;

    /**
     * Default padding configuration
     */
    public static PaddingStyle defaultStyle () {
        return new PaddingStyle(0, 0);
    }

    /**
     * @param l Left padding
     * @param t Top padding
     * @param r Right padding
     * @param b Bottom padding
     */
    public PaddingStyle (int l, int t, int r, int b) {
        this.l = l;
        this.t = t;
        this.r = r;
        this.b = b;
    }

    /**
     * @param x Horizontal padding
     * @param y Vertical padding
     */
    public PaddingStyle (int x, int y) {
        this.l = x;
        this.r = x;
        this.t = y;
        this.b = y;
    }

    /**
     * Left
     */
    public int getL () {
        return l;
    }

    /**
     * Left
     */
    public PaddingStyle setL (int l) {
        this.l = l;
        return this;
    }

    /**
     * Right
     */
    public int getR () {
        return r;
    }

    /**
     * Right
     */
    public PaddingStyle setR (int r) {
        this.r = r;
        return this;
    }

    /**
     * Top
     */
    public int getT () {
        return t;
    }

    /**
     * Top
     */
    public PaddingStyle setT (int t) {
        this.t = t;
        return this;
    }

    /**
     * Bottom
     */
    public int getB () {
        return b;
    }

    /**
     * Bottom
     */
    public PaddingStyle setB (int b) {
        this.b = b;
        return this;
    }
}
