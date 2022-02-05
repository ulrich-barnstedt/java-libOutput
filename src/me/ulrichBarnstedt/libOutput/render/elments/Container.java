package me.ulrichBarnstedt.libOutput.render.elments;

import me.ulrichBarnstedt.libOutput.render.style.BoxStyle;
import me.ulrichBarnstedt.libOutput.render.style.PaddingStyle;
import me.ulrichBarnstedt.libOutput.util.Wrapper;

public class Container extends Element {
    private boolean vertical;
    private Table table;

    /**
     * @param vertical If the elements should be aligned vertically
     * @param showBorder If the border should be shown
     */
    public Container (boolean vertical, boolean showBorder) {
        this.vertical = vertical;
        this.table = new Table(showBorder);
    }

    @Override
    void render (int x, int y) {
        this.table.render(x, y);
    }

    @Override
    int totalWidth () {
        return this.table.totalWidth();
    }

    @Override
    int totalHeight () {
        return this.table.totalHeight();
    }

    @Override
    void attachParent (Screen screen) {
        this.table.attachParent(screen);
    }

    /**
     * Add an element to the container
     * @param element Element to add
     * @return Instance for chaining
     */
    public Container addElement (Element element) {
        if (this.vertical) {
            this.table.addElement(0, element);
            return this;
        }

        this.table.addElement(this.table.filledColumnCount(), element);
        return this;
    }

    /**
     * Delete an element from the container
     * @param idx Index to delete
     */
    public void deleteElement (int idx) {
        if (this.vertical) {
            this.table.deleteElement(0, idx);
            return;
        }

        this.table.deleteColumn(idx);
    }

    /**
     * Get the element at the specified index
     * @param idx The index where to get the element
     * @return Instance for chaining
     */
    public Element getElement (int idx) {
        if (this.vertical) {
            return this.table.getElement(0, idx);
        }

        return this.table.getElement(idx, 0);
    }

    /**
     * Set the color of the border of the container
     * @param color Color-code to use
     * @return Instance for chaining
     */
    public Container setColor (String color) {
        this.table.setColor(color);
        return this;
    }

    /**
     * Set the color of the border of the container
     * @param color Color to use, see color package for possible inputs
     * @return Instance for chaining
     */
    public Container setColor (Wrapper color) {
        this.table.setColor(color);
        return this;
    }

    /**
     * Set the padding of the container
     * @param newPadding New padding to set to
     * @return Instance for chaining
     */
    public Container setPadding (PaddingStyle newPadding) {
        this.table.setPadding(newPadding);
        return this;
    }

    /**
     * Set the title of the container
     * @param title New title
     * @return Instance for chaining
     */
    public Container setTitle (String title) {
        this.table.setTitle(title);
        return this;
    }

    /**
     * Change the characters out of which the container is drawn
     * @param newStyle New style to draw
     * @return Instance for chaining
     */
    public Container setBoxDrawingCharacters (BoxStyle newStyle) {
        this.table.setBoxDrawingCharacters(newStyle);
        return this;
    }
}
