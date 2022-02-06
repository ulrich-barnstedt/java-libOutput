package ulrichbarnstedt.lib.output.color;

import ulrichbarnstedt.lib.output.util.Wrapper;
import ulrichbarnstedt.lib.output.Term;

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
