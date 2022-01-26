package me.ulrichBarnstedt.libOutput;

public class StringLiteral extends Wrapper {
    private String str;

    public StringLiteral(String str) {
        this.str = str;
    }

    public String toString () {
        return this.str;
    }
}
