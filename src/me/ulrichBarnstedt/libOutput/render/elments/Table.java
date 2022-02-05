package me.ulrichBarnstedt.libOutput.render.elments;

import java.util.ArrayList;

/**
 * Table element, without borders around the elements.
 * Should be used with boxes or other layout elements.
 */
public class Table extends ElementBox<Table> {
    public Table (boolean showBorder) {
        super(showBorder, false);
    }

    @Override
    protected void handleSizeRecalculation () {
        int borderChange = showBorder ? 2 : 0;

        this.height = this.sizeTable.getAxisSum().getY() + borderChange + this.paddingStyle.getB() + this.paddingStyle.getT();
        this.width  = this.sizeTable.getAxisSum().getX() + borderChange + this.paddingStyle.getL() + this.paddingStyle.getR();
    }

    @Override
    protected void renderBoxArtifacts (int x, int y) {}

    @Override
    protected void renderBoxContent (int x, int y) {
        x += this.paddingStyle.getL();
        y += this.paddingStyle.getT();

        for (int listX = 0; listX < this.content.size(); listX++) {
            ArrayList<Element> col = this.content.get(listX);
            int yOffset = 0;

            for (int listY = 0; listY < col.size(); listY++) {
                col.get(listY).render(x, y + yOffset);
                yOffset += this.sizeTable.getYSum().get(listY);
            }

            x += this.sizeTable.getXSum().get(listX);
        }
    }
}
