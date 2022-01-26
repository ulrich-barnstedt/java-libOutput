package me.ulrichBarnstedt.libOutput.render;

/**
 * Base class for all renderable elements.
 * Not an interface because of access to methods.
 */
public abstract class Element {
    abstract void render (int x, int y);
    abstract int totalWidth ();
    abstract int totalHeight ();
    abstract void attachParent (Screen screen);
}
