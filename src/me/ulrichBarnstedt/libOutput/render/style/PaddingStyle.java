package me.ulrichBarnstedt.libOutput.render.style;

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
    public void setL (int l) {
        this.l = l;
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
    public void setR (int r) {
        this.r = r;
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
    public void setT (int t) {
        this.t = t;
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
    public void setB (int b) {
        this.b = b;
    }
}
