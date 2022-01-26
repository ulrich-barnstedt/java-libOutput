package me.ulrichBarnstedt.libOutput.terminal;

import me.ulrichBarnstedt.libOutput.StringLiteral;
import me.ulrichBarnstedt.libOutput.Term;
import me.ulrichBarnstedt.libOutput.Wrapper;

public class Cursor {
    public static final StringLiteral HOME = new StringLiteral(Term.ESCAPE + "[H");

    public static Wrapper toPos (int x, int y) {
        //System.out.print(x + "|" + y);
        return new StringLiteral(Term.ESCAPE +  "[" + (y + 1) + ";" + ( x + 1 ) + "H");
    }

    public static Wrapper up (int count) {
        return new StringLiteral(Term.ESCAPE + "["+ count + "A");
    }

    public static Wrapper down (int count) {
        return new StringLiteral(Term.ESCAPE + "["+ count + "B");
    }

    public static Wrapper right (int count) {
        return new StringLiteral(Term.ESCAPE + "["+ count + "C");
    }

    public static Wrapper left (int count) {
        return new StringLiteral(Term.ESCAPE + "["+ count + "D");
    }

    public static Wrapper toColumn (int col) {
        return new StringLiteral(Term.ESCAPE + "["+ col + "G");
    }
}
