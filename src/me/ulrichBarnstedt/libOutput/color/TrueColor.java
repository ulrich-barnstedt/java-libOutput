package me.ulrichBarnstedt.libOutput.color;

import me.ulrichBarnstedt.libOutput.Wrapper;
import me.ulrichBarnstedt.libOutput.Term;

/**
 * Representation of true-color escape codes
 */
public class TrueColor extends Wrapper {
    private int modifier;
    private int r;
    private int g;
    private int b;

    /**
     * @param r Red
     * @param g Green
     * @param b Blue
     * @param isFG If the color is foreground or background
     */
    public TrueColor(int r, int g, int b, boolean isFG) {
        this.r = r;
        this.b = b;
        this.g = g;
        this.modifier = isFG ? 38 : 48;
    }

    @Override
    public String toString() {
        return Term.ESCAPE + "[" + modifier + ";2;" + r + ";" + g + ";" + b + "m";
    }
}
