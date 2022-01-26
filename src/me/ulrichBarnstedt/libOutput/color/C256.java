package me.ulrichBarnstedt.libOutput.color;

import me.ulrichBarnstedt.libOutput.Wrapper;
import me.ulrichBarnstedt.libOutput.Term;

public class C256 extends Wrapper {
    private int modifier;
    private int ID;

    public C256(int ID, boolean isFG) {
        this.ID = ID;
        this.modifier = isFG ? 38 : 48;
    }

    @Override
    public String toString() {
        return Term.ESCAPE + "[" + modifier + ";5;" + ID + "m";
    }
}
