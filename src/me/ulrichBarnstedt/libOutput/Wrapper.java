package me.ulrichBarnstedt.libOutput;

/**
 * Basic string wrapper
 * @see StringLiteral
 */
public class Wrapper {
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
}
