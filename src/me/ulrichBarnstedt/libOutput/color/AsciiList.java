package me.ulrichBarnstedt.libOutput.color;

/**
 * Complete list of 3-4 bit color codes for the terminal
 */
public class AsciiList {
    private AsciiList () {}

    public static final Ascii RESET = new Ascii(0);

    public static final Ascii FG_BLACK = new Ascii(30);
    public static final Ascii FG_RED = new Ascii(31);
    public static final Ascii FG_GREEN = new Ascii(32);
    public static final Ascii FG_YELLOW = new Ascii(33);
    public static final Ascii FG_BLUE = new Ascii(34);
    public static final Ascii FG_MAGENTA = new Ascii(35);
    public static final Ascii FG_CYAN = new Ascii(36);
    public static final Ascii FG_WHITE = new Ascii(37);
    public static final Ascii FG_DEFAULT = new Ascii(39);

    public static final Ascii BG_BLACK = new Ascii(40);
    public static final Ascii BG_RED = new Ascii(41);
    public static final Ascii BG_GREEN = new Ascii(42);
    public static final Ascii BG_YELLOW = new Ascii(43);
    public static final Ascii BG_BLUE = new Ascii(44);
    public static final Ascii BG_MAGENTA = new Ascii(45);
    public static final Ascii BG_CYAN = new Ascii(46);
    public static final Ascii BG_WHITE = new Ascii(47);
    public static final Ascii BG_DEFAULT = new Ascii(49);
}
