package me.ulrichBarnstedt.libOutput.render;

import java.util.ArrayList;

public class Table extends ElementBox<Table> {
    public Table (boolean showBorder) {
        super(showBorder);
    }

    @Override
    protected void recalculateSize () {
        int borderChange = showBorder ? 2 : 0;
        this.height = SizeHelper.height(this.content, Element::totalHeight) + borderChange + this.paddingStyle.getT() + this.paddingStyle.getB();
        this.width = SizeHelper.width(this.content, Element::totalWidth) + borderChange + this.paddingStyle.getL() + this.paddingStyle.getR();
    }

    @Override
    protected void renderBoxArtifacts (int x, int y) {}

    @Override
    protected void renderBoxContent (int x, int y) {
        x += this.paddingStyle.getL();
        y += this.paddingStyle.getT();

        for (ArrayList<Element> col : this.content) {
            int colWidth = 0;
            int yOffset = 0;

            for (Element e : col) {
                e.render(x, y + yOffset);
                yOffset += e.totalHeight();

                int elementWidth = e.totalWidth();
                if (elementWidth > colWidth) colWidth = elementWidth;
            }

            x += colWidth;
        }
    }
}
