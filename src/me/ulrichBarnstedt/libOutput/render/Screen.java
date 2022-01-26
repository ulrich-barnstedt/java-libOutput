package me.ulrichBarnstedt.libOutput.render;

import me.ulrichBarnstedt.libOutput.terminal.Clear;

public class Screen {
    private Element content;

    public Screen (Element e) {
        this.setElement(e);
    }

    public void setElement (Element element) {
        element.attachParent(this);
        this.content = element;
        //this.redraw(); -- dont draw instantly
    }

    public void redraw () {
        if (this.content == null) return;

        Clear.SCREEN.print();
        this.content.render(0, 0);
    }
}
