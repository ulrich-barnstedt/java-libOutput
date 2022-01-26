package me.ulrichBarnstedt.libOutput.render;

import me.ulrichBarnstedt.libOutput.color.AsciiList;
import me.ulrichBarnstedt.libOutput.terminal.Cursor;

import java.util.ArrayList;
import java.util.Arrays;

public class Container implements Element {
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

    public Container setPadding (int xPadding, int yPadding) {
        this.xPadding = xPadding;
        this.yPadding = yPadding;

        this.recalculateSizes();
        this.attemptRedraw();

        return this;
    }

    public Container setTitle (String title) {
        this.title = title;
        this.recalculateSizes();
        this.attemptRedraw();

        return this;
    }

    public Container setColor (String color) {
        this.color = color;
        this.attemptRedraw();

        return this;
    }

    // --------------------- Element Management

    public Container addElement (Element element) {
        element.attachParent(this.boundScreen);
        this.content.add(element);

        this.recalculateSizes();
        this.attemptRedraw();

        return this;
    }

    public Element getElement (int idx) {
        return this.content.get(idx);
    }

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
    public void render (int x, int y) {
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
    public int totalWidth () {
        return this.width;
    }

    @Override
    public int totalHeight () {
        return this.height;
    }

    @Override
    public void attachParent (Screen screen) {
        this.boundScreen = screen;
        for (Element e : this.content)
            e.attachParent(screen);
    }
}

//System.out.println("W/H: " + boxWidth + "/" + boxHeight);