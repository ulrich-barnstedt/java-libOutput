package me.ulrichBarnstedt.libOutput.util;

/**
 * Basic string wrapper
 * @see StringLiteral
 */
abstract public class Wrapper {
    /**
     * Print the string
     */
    public void print() {
        System.out.print(this.toString());
    }

    /**
     * Short form of .print()
     */
    public void p() {
        this.print();
    }

    /**
     * Require classes to implement toString()
     */
    abstract public String toString ();
}
