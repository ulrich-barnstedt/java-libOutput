package ulrichbarnstedt.lib.output.render.elments;

import ulrichbarnstedt.lib.output.color.AsciiList;
import ulrichbarnstedt.lib.output.terminal.Cursor;
import ulrichbarnstedt.lib.output.util.Wrapper;

/**
 * Single, renderable line of text
 * Note: actually only renders one high, so using line breaks is not an option
 * @see MultilineText
 */
public class Text extends Element {
    private String content;
    private Screen boundScreen;
    private String color = "";

    /**
     * @param content String to display
     */
    public Text (String content) {
        this.content = content;
    }

    /**
     * Set the string to display
     * @param content
     * @return Instance for chaining
     */
    public Text setContent (String content) {
        this.content = content;
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    /**
     * Set the display color
     * @param color The color as a string (normally an escape code, see COLOR part of library for helper classes which support these)
     * @return Instance for chaining
     */
    public Text setColor (String color) {
        this.color = color;
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    /**
     * Set the display color
     * @param color Color as a wrapper instance
     * @return Instance for chaining
     */
    public Text setColor (Wrapper color) {
        return this.setColor(color.toString());
    }

    /**
     * Get displayed string
     * @return
     */
    public String getContent () {
        return content;
    }

    @Override
    void render (int x, int y) {
        System.out.print(Cursor.toPos(x, y) + this.color + this.content + AsciiList.RESET);
    }

    @Override
    int totalWidth () {
        return this.content.length();
    }

    @Override
    int totalHeight () {
        return 1;
    }

    @Override
    void attachParent (Screen screen) {
        this.boundScreen = screen;
    }
}
