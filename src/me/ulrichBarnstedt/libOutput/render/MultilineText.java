package me.ulrichBarnstedt.libOutput.render;

import java.util.ArrayList;

/**
 * Text spanning over multiple lines
 * @see Text
 */
public class MultilineText extends Element {
    private ArrayList<Text> content;
    private Screen boundScreen;
    private int totalWidth;

    /**
     * @param in A list of predefined strings to add
     */
    public MultilineText (String ... in) {
        this.content = new ArrayList<>();
        for (String s : in) {
            content.add(new Text(s));
        }
    }

    /**
     * Set a line of the multiline string to some text
     * @param idx Line to set
     * @param to Text to set to
     * @return Instance for chaining
     */
    public MultilineText set (int idx, Text to) {
        to.attachParent(this.boundScreen);
        this.content.set(idx, to);
        this.recalculateWidth();
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    /**
     * Add a text element to the end
     * @param content
     * @return Instance for chaining
     */
    public MultilineText add (Text content) {
        content.attachParent(this.boundScreen);
        this.content.add(content);
        this.recalculateWidth();
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    /**
     * Get a text element by index (order added)
     * @param idx
     * @return Requested element
     */
    public Text get (int idx) {
        return this.content.get(idx);
    }

    /**
     * Delete an element by index
     * @param idx
     */
    public void delete (int idx) {
        this.content.remove(idx);
        this.recalculateWidth();
        if (this.boundScreen != null) this.boundScreen.redraw();
    }

    private void recalculateWidth () {
        this.totalWidth = 0;
        for (Text text : this.content) {
            if (text.getContent().length() < this.totalWidth) continue;
            this.totalWidth = text.getContent().length();
        }
    }

    @Override
    void render (int x, int y) {
        for (int yCounter = 0; yCounter < this.content.size(); yCounter++)
            this.content.get(yCounter).render(x, yCounter + y);
    }

    @Override
    int totalWidth () {
        return this.totalWidth;
    }

    @Override
    int totalHeight () {
        return this.content.size();
    }

    @Override
    void attachParent (Screen screen) {
        this.boundScreen = screen;
        for (Text t : this.content)
            t.attachParent(screen);
    }
}
