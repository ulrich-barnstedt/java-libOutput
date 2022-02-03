package me.ulrichBarnstedt.libOutput.terminal;

import me.ulrichBarnstedt.libOutput.util.StringLiteral;
import me.ulrichBarnstedt.libOutput.Term;

/**
 * Terminal codes for clearing the terminal
 */
public class Clear {
    public static StringLiteral SCREEN = new StringLiteral(Term.ESCAPE + "[2J");
    public static StringLiteral CURRENT_LINE = new StringLiteral(Term.ESCAPE + "[2K");
}
