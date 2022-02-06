package ulrichbarnstedt.lib.output.render.elments;

/**
 * Empty element, can be used in tables to force columns/rows to have padding applied
 */
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
