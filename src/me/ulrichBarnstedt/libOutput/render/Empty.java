package me.ulrichBarnstedt.libOutput.render;

public class Empty extends Element {
    @Override
    void render (int x, int y) {}

    @Override
    int totalWidth () {
        return 0;
    }

    @Override
    int totalHeight () {
        return 0;
    }

    @Override
    void attachParent (Screen screen) {}
}
