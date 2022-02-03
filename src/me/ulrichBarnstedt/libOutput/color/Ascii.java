package me.ulrichBarnstedt.libOutput.color;

import me.ulrichBarnstedt.libOutput.util.Wrapper;
import me.ulrichBarnstedt.libOutput.Term;

/**
 * Representation of standard 3-4 bit color escape codes
 */
public class Ascii extends Wrapper {
    private int colorCode;

    /**
     * @param colorCode The color code represented as decimal
     */
    public Ascii(int colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return Term.ESCAPE + "[" + colorCode + "m";
    }
}
