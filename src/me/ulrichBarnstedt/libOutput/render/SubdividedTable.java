package me.ulrichBarnstedt.libOutput.render;

import java.util.ArrayList;

public class SubdividedTable extends ElementBox<SubdividedTable> {
    protected SubdividedTable (boolean showBorder) {
        super(showBorder);
    }

    @Override
    protected void recalculateSize () {
        int borderChange = showBorder ? 2 : 0;
        int xItems = this.content.size();
        int yItems = 0;

        for (ArrayList<Element> row : this.content)
            if (row.size() > yItems) yItems = row.size();

        this.height = SizeHelper.height(this.content, (Element e) -> e.totalHeight() + this.paddingStyle.getT() + this.paddingStyle.getB()) + borderChange + yItems - 1;
        this.width = SizeHelper.width(this.content, (Element e) -> e.totalWidth() + this.paddingStyle.getR() + this.paddingStyle.getL()) + borderChange + xItems - 1;
    }

    @Override
    protected void renderBoxArtifacts (int x, int y) {

    }

    @Override
    protected void renderBoxContent (int x, int y) {

    }
}
