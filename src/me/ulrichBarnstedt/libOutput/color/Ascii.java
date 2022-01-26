package me.ulrichBarnstedt.libOutput.color;

import me.ulrichBarnstedt.libOutput.Wrapper;
import me.ulrichBarnstedt.libOutput.Term;

public class Ascii extends Wrapper {
    private int colorCode;

    Ascii(int colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return Term.ESCAPE + "[" + colorCode + "m";
    }
}
