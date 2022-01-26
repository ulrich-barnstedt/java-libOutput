package me.ulrichBarnstedt.libOutput.render;

public interface Element {
    public void render (int x, int y);
    public int totalWidth ();
    public int totalHeight ();
    public void attachParent (Screen screen);
}
