package me.ulrichBarnstedt.libOutput.util;

/**
 * String Wrapper class.
 * Can be used like a normal string (.toString) or directly outputted by calling .print()
 * @see Wrapper
 */
public class StringLiteral extends Wrapper {
    private String str;

    public StringLiteral(String str) {
        this.str = str;
    }

    public String toString () {
        return this.str;
    }
}
