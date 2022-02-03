package me.ulrichBarnstedt.libOutput.render;

import java.util.ArrayList;

/**
 * Table element with borders around each separate element
 */
public class SubdividedTable extends ElementBox<SubdividedTable> {
    public SubdividedTable (boolean showBorder) {
        super(showBorder, true);
    }

    @Override
    protected void handleSizeRecalculation () {
        int borderChange = showBorder ? 2 : 0;

    }

    @Override
    protected void renderBoxArtifacts (int x, int y) {

    }

    @Override
    protected void renderBoxContent (int x, int y) {

    }
}
