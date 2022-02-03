package me.ulrichBarnstedt.libOutput.util;

/**
 * Simple tuple like class which can store two elements of any type
 * @param <X>
 * @param <Y>
 */
public class Pair<X, Y> {
    private X x;
    private Y y;

    public Pair (X x, Y y) {
        this.set(x, y);
    }

    public X getX () {
        return x;
    }

    public void setX (X x) {
        this.x = x;
    }

    public Y getY () {
        return y;
    }

    public void setY (Y y) {
        this.y = y;
    }

    /**
     * Set both values
     * @param x X value
     * @param y Y value
     */
    public void set (X x, Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get X shorthand
     * @return X
     */
    public X x() {
        return x;
    }

    /**
     * Get Y shorthand
     * @return Y
     */
    public Y y () {
        return y;
    }
}
