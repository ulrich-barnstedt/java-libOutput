package ulrichbarnstedt.lib.output.terminal;

import ulrichbarnstedt.lib.output.util.StringLiteral;
import ulrichbarnstedt.lib.output.Term;

/**
 * Terminal codes for clearing the terminal
 */
public class Clear {
    public static StringLiteral SCREEN = new StringLiteral(Term.ESCAPE + "[2J");
    public static StringLiteral CURRENT_LINE = new StringLiteral(Term.ESCAPE + "[2K");
}
