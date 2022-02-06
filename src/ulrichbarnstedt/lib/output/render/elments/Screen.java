package ulrichbarnstedt.lib.output.render.elments;

import ulrichbarnstedt.lib.output.terminal.Clear;
import ulrichbarnstedt.lib.output.terminal.Cursor;
import ulrichbarnstedt.lib.output.util.Wrapper;

/**
 * The base renderer for elements, base for displaying
 * @see ScreenManager
 */
public class Screen {
    private Element content;

    /**
     * @param e The base element of the screen - required so the screen is renderable
     */
    public Screen (Element e) {
        this.setElement(e);
    }

    /**
     * Set the base element
     * @param element
     */
    public void setElement (Element element) {
        element.attachParent(this);
        this.content = element;
        //this.redraw(); -- dont draw instantly
    }

    /**
     * Force this screen to redraw - manual use is NOT recommended, is ALWAYS called automatically when needed
     */
    public void redraw () {
        if (this.content == null) return;

        Clear.SCREEN.print();
        this.content.render(0, 0);
    }

    /**
     * Move the cursor to the bottom of the content, useful if you want to continue using the terminal after drawing.
     * @return Wrapper instance for printing
     */
    public Wrapper cursorToEnd () {
        return Cursor.toPos(0, this.content.totalHeight());
    }
}
