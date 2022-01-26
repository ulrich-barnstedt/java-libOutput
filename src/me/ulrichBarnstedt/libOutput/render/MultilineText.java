package me.ulrichBarnstedt.libOutput.render;

import java.util.ArrayList;

public class MultilineText implements Element {
    private ArrayList<Text> content;
    private Screen boundScreen;
    private int totalWidth;

    public MultilineText (String ... in) {
        this.content = new ArrayList<>();
        for (String s : in) {
            content.add(new Text(s));
        }
    }

    public MultilineText set (int idx, Text to) {
        to.attachParent(this.boundScreen);
        this.content.set(idx, to);
        this.recalculateWidth();
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    public MultilineText add (Text content) {
        content.attachParent(this.boundScreen);
        this.content.add(content);
        this.recalculateWidth();
        if (this.boundScreen != null) this.boundScreen.redraw();

        return this;
    }

    public Text get (int idx) {
        return this.content.get(idx);
    }

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
    public void render (int x, int y) {
        for (int yCounter = 0; yCounter < this.content.size(); yCounter++)
            this.content.get(yCounter).render(x, yCounter + y);
    }

    @Override
    public int totalWidth () {
        return this.totalWidth;
    }

    @Override
    public int totalHeight () {
        return this.content.size();
    }

    @Override
    public void attachParent (Screen screen) {
        this.boundScreen = screen;
        for (Text t : this.content)
            t.attachParent(screen);
    }
}
