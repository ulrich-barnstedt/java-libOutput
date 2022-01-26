package me.ulrichBarnstedt.libOutput.render;

import me.ulrichBarnstedt.libOutput.color.AsciiList;
import me.ulrichBarnstedt.libOutput.terminal.Cursor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Container class for use in UI.
 * Can contain other elements, can have a border.
 * Supports colors, padding, and other functions.
 */
public class Container extends Element {
    private boolean showBorder;
    private boolean vertical;
    private String title;
    private ArrayList<Element> content;
    private Screen boundScreen;
    private int xPadding;
    private int yPadding;
    private String color = "";

    private int height;
    private int width;

    private String B_VERTICAL = "│";
    private String B_HORIZONTAL = "─";
    private String B_LT = "┌";
    private String B_LB = "└";
    private String B_RT = "┐";
    private String B_RB = "┘";

    /**
     * @param showBorder If the container has a border
     * @param vertical If the elements are aligned vertical (else horizontal)
     * @param elements An optional list of predefined elements
     */
    public Container (boolean showBorder, boolean vertical, Element ... elements) {
        this.showBorder = showBorder;
        this.content = new ArrayList<>();
        this.vertical = vertical;
        this.xPadding = 0;
        this.yPadding = 0;
        this.content.addAll(Arrays.asList(elements));

        //init
        this.recalculateSizes();
    }

    // --------------------- Config

    /**
     * Define a set of custom border characters
     * @param vertical
     * @param horizontal
     * @param leftTop
     * @param leftBottom
     * @param rightTop
     * @param rightBottom
     * @return Instance for chaining
     */
    public Container customBorderCharacters (String vertical, String horizontal, String leftTop, String leftBottom, String rightTop, String rightBottom) {
        this.B_VERTICAL = vertical;
        this.B_HORIZONTAL = horizontal;
        this.B_LT = leftTop;
        this.B_LB = leftBottom;
        this.B_RT = rightTop;
        this.B_RB = rightBottom;

        if (this.boundScreen != null) this.boundScreen.redraw();
        return this;
    }

    /**
     * Configure padding of the container
     * @param xPadding Padding on x-axis
     * @param yPadding Padding on y-axis
     * @return Instance for chaining
     */
    public Container setPadding (int xPadding, int yPadding) {
        this.xPadding = xPadding;
        this.yPadding = yPadding;

        this.recalculateSizes();
        this.attemptRedraw();

        return this;
    }

    /**
     * Configure title of container
     * @param title
     * @return Instance for chaining
     */
    public Container setTitle (String title) {
        this.title = title;
        this.recalculateSizes();
        this.attemptRedraw();

        return this;
    }

    /**
     * Set the color of the border and title
     * @param color The color as a string (normally an escape code, see COLOR part of library for helper classes which support these)
     * @return Instance for chaining
     */
    public Container setColor (String color) {
        this.color = color;
        this.attemptRedraw();

        return this;
    }

    // --------------------- Element Management

    /**
     * Add an element to the container
     * @param element
     * @return Instance for chaining
     */
    public Container addElement (Element element) {
        element.attachParent(this.boundScreen);
        this.content.add(element);

        this.recalculateSizes();
        this.attemptRedraw();

        return this;
    }

    /**
     * Get an element from the container by index (by order added)
     * @param idx
     * @return Requested element
     */
    public Element getElement (int idx) {
        return this.content.get(idx);
    }

    /**
     * Delete an element at the specified index (by order added)
     * @param idx
     */
    public void deleteElement (int idx) {
        this.content.remove(idx);

        this.recalculateSizes();
        this.attemptRedraw();
    }

    // --------------------- Rendering

    private void recalculateSizes () {
        int totalHeight = 0;
        int totalWidth = 0;
        int maxHeight = 0;
        int maxWidth = 0;

        for (Element e : this.content) {
            int e_width = e.totalWidth();
            int e_height = e.totalHeight();

            totalHeight += e_height;
            totalWidth += e_width;

            if (e_height > maxHeight) maxHeight = e_height;
            if (e_width > maxWidth) maxWidth = e_width;
        }

        int borderChange = showBorder ? 2 : 0;
        this.height = vertical ? totalHeight + this.yPadding * 2 + borderChange : maxHeight + this.yPadding * 2 + borderChange;
        this.width = vertical ? maxWidth + this.xPadding * 2 + borderChange : totalWidth + this.xPadding * 2 + borderChange;
    }

    private void renderBox (int x, int y) {
        //Color
        System.out.print(this.color);

        //Top bar
        System.out.print(Cursor.toPos(x, y) + this.B_LT);
        for (int xOffset = 1; xOffset < this.width - 1; xOffset++) {
            System.out.print(this.B_HORIZONTAL);
        }
        System.out.print(this.B_RT);

        //Walls
        for (int yOffset = 1; yOffset < this.height - 1; yOffset++) {
            System.out.print(Cursor.toPos(x, yOffset + y) + this.B_VERTICAL);
            System.out.print(Cursor.toPos(x + this.width - 1, yOffset + y) + this.B_VERTICAL);
        }

        //Bottom bar
        System.out.print(Cursor.toPos(x, y + this.height - 1) + this.B_LB);
        for (int xOffset = 1; xOffset < this.width - 1; xOffset++) {
            System.out.print(this.B_HORIZONTAL);
        }
        System.out.print(this.B_RB);

        //Title
        if (this.title != null) {
            System.out.print(Cursor.toPos(x + 2, y) + this.title);
        }

        //Reset color
        AsciiList.RESET.p();
    }

    @Override
    void render (int x, int y) {
        if (this.showBorder) {
            this.renderBox(x, y);
            x++;
            y++;
        }

        y += this.yPadding;
        x += this.xPadding;

        //Content
        for (Element e : this.content) {
            e.render(x ,y);
            if (vertical) {
                y += e.totalHeight();
            } else {
                x += e.totalWidth();
            }
        }
    }

    private void attemptRedraw () {
        if (this.boundScreen != null) this.boundScreen.redraw();
    }

    // --------------------- Standard Functions

    @Override
    int totalWidth () {
        return this.width;
    }

    @Override
    int totalHeight () {
        return this.height;
    }

    @Override
    void attachParent (Screen screen) {
        this.boundScreen = screen;
        for (Element e : this.content)
            e.attachParent(screen);
    }
}

//System.out.println("W/H: " + boxWidth + "/" + boxHeight);