package ulrichbarnstedt.lib.output.render.elments;

import ulrichbarnstedt.lib.output.color.AsciiList;
import ulrichbarnstedt.lib.output.render.style.BoxStyle;
import ulrichbarnstedt.lib.output.render.style.PaddingStyle;
import ulrichbarnstedt.lib.output.terminal.Cursor;
import ulrichbarnstedt.lib.output.util.Wrapper;

import java.util.ArrayList;

/**
 * Abstract class representing table-like containers
 * @param <T>
 */
public abstract class ElementBox<T extends ElementBox<T>> extends Element {
    protected ArrayList<ArrayList<Element>> content;
    protected Screen boundScreen;
    protected String title;
    protected String color;
    protected boolean showBorder;
    protected SizeLayout sizeTable;
    private boolean applyPaddingToSizeTable;

    protected BoxStyle boxDrawingStyle;
    protected PaddingStyle paddingStyle;

    protected int height;
    protected int width;

    protected ElementBox (boolean showBorder, boolean applyPaddingToSizeTable) {
        this.showBorder = showBorder;
        this.content = new ArrayList<>();
        this.color = "";
        this.applyPaddingToSizeTable = applyPaddingToSizeTable;
        this.sizeTable = new SizeLayout(new PaddingStyle(0, 0, 0, 0));

        this.boxDrawingStyle = BoxStyle.defaultStyle();
        this.paddingStyle = PaddingStyle.defaultStyle();

        this.recalculateSize();
    }

    // ------------------------------- Logic methods

    abstract protected void handleSizeRecalculation ();
    abstract protected void renderBoxArtifacts (int x, int y);
    abstract protected void renderBoxContent (int x, int y);

    protected void recalculateSize () {
        this.sizeTable.recalculate(this.content);
        this.handleSizeRecalculation();
    }

    protected void attemptRedraw () {
        if (this.boundScreen != null) this.boundScreen.redraw();
    }

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
        for (ArrayList<Element> e : this.content)
            for (Element i : e)
                i.attachParent(screen);
    }

    @Override
    void render (int x, int y) {
        System.out.print(this.color);

        if (this.showBorder)
            this.renderInitialBorder(x, y);
        this.renderBoxArtifacts(x, y);
        this.renderTitle(x, y);

        AsciiList.RESET.p();

        if (this.showBorder) {
            y++;
            x++;
        }
        this.renderBoxContent(x, y);
    }

    private void renderInitialBorder (int x, int y) {
        //Top bar
        System.out.print(Cursor.toPos(x, y) + this.boxDrawingStyle.getLT());
        for (int xOffset = 1; xOffset < this.width - 1; xOffset++) {
            System.out.print(this.boxDrawingStyle.getHORIZONTAL());
        }
        System.out.print(this.boxDrawingStyle.getRT());

        //Walls
        for (int yOffset = 1; yOffset < this.height - 1; yOffset++) {
            System.out.print(Cursor.toPos(x, yOffset + y) + this.boxDrawingStyle.getVERTICAL());
            System.out.print(Cursor.toPos(x + this.width - 1, yOffset + y) + this.boxDrawingStyle.getVERTICAL());
        }

        //Bottom bar
        System.out.print(Cursor.toPos(x, y + this.height - 1) + this.boxDrawingStyle.getLB());
        for (int xOffset = 1; xOffset < this.width - 1; xOffset++) {
            System.out.print(this.boxDrawingStyle.getHORIZONTAL());
        }
        System.out.print(this.boxDrawingStyle.getRB());
    }

    private void renderTitle (int x, int y) {
        if (this.title != null && this.showBorder) {
            System.out.print(Cursor.toPos(x + 2, y) + this.title);
        }
    }

    private void resizeArray (int to) {
        while (this.content.size() < to)
            this.content.add(new ArrayList<>());
    }

    // ------------------------------- Setters / modifying styles

    /**
     * Define a set of custom border characters
     * @param newStyle New box drawing style
     * @return Instance for chaining
     */
    public T setBoxDrawingCharacters (BoxStyle newStyle) {
        this.boxDrawingStyle = newStyle;

        this.attemptRedraw();
        return (T) this;
    }

    /**
     * Configure padding of the container
     * @param newPadding New padding settings
     * @return Instance for chaining
     */
    public T setPadding (PaddingStyle newPadding) {
        this.paddingStyle = newPadding;

        if (this.applyPaddingToSizeTable)
            this.sizeTable.setElementPadding(newPadding);

        this.recalculateSize();
        this.attemptRedraw();

        return (T) this;
    }

    /**
     * Configure title of container
     * @param title New title
     * @return Instance for chaining
     */
    public T setTitle (String title) {
        this.title = title;
        this.attemptRedraw();

        return (T) this;
    }

    /**
     * Set the color of the border and title
     * @param color The color as a string (normally an escape code, see COLOR part of library for helper classes which support these)
     * @return Instance for chaining
     */
    public T setColor (String color) {
        this.color = color;
        this.attemptRedraw();

        return (T) this;
    }

    /**
     * Set the color of the border and title
     * @param color Color as a wrapper instance
     * @return Instance for chaining
     */
    public T setColor (Wrapper color) {
        return this.setColor(color.toString());
    }

    /**
     * Add an element to a table, will be appended at end
     * @param x Position on the x-axis to insert the element
     * @param element Element to add
     * @return Instance for chaining
     */
    public T addElement (int x, Element element) {
        this.resizeArray(x + 1);
        this.content.get(x).add(element);

        this.recalculateSize();
        this.attemptRedraw();

        return (T) this;
    }

    /**
     * Get an element by its indexes
     * @param x X index
     * @param y Y index
     * @return Element
     */
    public Element getElement (int x, int y) {
        return this.content.get(x).get(y);
    }

    /**
     * Delete an element at the specified index
     * @param x X index
     * @param y Y index
     */
    public void deleteElement (int x, int y) {
        this.content.get(x).remove(y);
        this.recalculateSize();
        this.attemptRedraw();
    }

    /**
     * Get the total amount of columns in the table, includes columns with 0 content
     * @return Amount of columns
     */
    public int columnCount () {
        return this.content.size();
    }

    /**
     * Get the amount of columns in the table, excluding columns with 0 content
     * @return Amount of columns
     */
    public int filledColumnCount () {
        for (int i = this.content.size() - 1; i >= 0; i--) {
            if (this.content.get(i).size() == 0) continue;
            return i + 1;
        }

        return 0;
    }

    /**
     * Get the total amount of rows in the table
     * @param x Column
     * @return Amount of elements in this column
     */
    public int rowCount (int x) {
        return this.content.get(x).size();
    }

    /**
     * Delete a column
     * @param x The index of the column
     */
    public void deleteColumn (int x) {
        this.content.remove(x);
        this.recalculateSize();
        this.attemptRedraw();
    }
}
