package me.ulrichBarnstedt.libOutput.color;

import me.ulrichBarnstedt.libOutput.StringLiteral;
import me.ulrichBarnstedt.libOutput.Term;

public class TextFormatting {
    public static StringLiteral RESET = new StringLiteral(Term.ESCAPE + "[0m");

    public static StringLiteral SET_BOLD = new StringLiteral(Term.ESCAPE + "[1m");
    public static StringLiteral NO_BOLD = new StringLiteral(Term.ESCAPE + "[22m");
    public static StringLiteral SET_DIM = new StringLiteral(Term.ESCAPE + "[2m");
    public static StringLiteral NO_DIM = new StringLiteral(Term.ESCAPE + "[22m");
    public static StringLiteral SET_ITALIC = new StringLiteral(Term.ESCAPE + "[3m");
    public static StringLiteral NO_ITALIC = new StringLiteral(Term.ESCAPE + "[23m");
    public static StringLiteral SET_UNDERLINE = new StringLiteral(Term.ESCAPE + "[4m");
    public static StringLiteral NO_UNDERLINE = new StringLiteral(Term.ESCAPE + "[24m");
    public static StringLiteral SET_BLINK = new StringLiteral(Term.ESCAPE + "[5m");
    public static StringLiteral NO_BLINK = new StringLiteral(Term.ESCAPE + "[25m");
    public static StringLiteral SET_INVERSE = new StringLiteral(Term.ESCAPE + "[7m");
    public static StringLiteral NO_INVERSE = new StringLiteral(Term.ESCAPE + "[27m");
    public static StringLiteral SET_HIDDEN = new StringLiteral(Term.ESCAPE + "[8m");
    public static StringLiteral NO_HIDDEN = new StringLiteral(Term.ESCAPE + "[28m");
    public static StringLiteral SET_STRIKETHROUGH = new StringLiteral(Term.ESCAPE + "[9m");
    public static StringLiteral NO_STRIKETHROUGH = new StringLiteral(Term.ESCAPE + "[29m");
}
