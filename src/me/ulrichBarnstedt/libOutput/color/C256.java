package me.ulrichBarnstedt.libOutput.color;

import me.ulrichBarnstedt.libOutput.Wrapper;
import me.ulrichBarnstedt.libOutput.Term;

/**
 * Representation of 8-bit terminal colors, lookup index for color codes
 */
public class C256 extends Wrapper {
    private int modifier;
    private int ID;

    /**
     * @param ID The ID of the color (see table)
     * @param isFG If the color is background or foreground color
     */
    public C256(int ID, boolean isFG) {
        this.ID = ID;
        this.modifier = isFG ? 38 : 48;
    }

    @Override
    public String toString() {
        return Term.ESCAPE + "[" + modifier + ";5;" + ID + "m";
    }
}
