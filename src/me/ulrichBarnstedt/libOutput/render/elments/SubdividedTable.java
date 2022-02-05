package me.ulrichBarnstedt.libOutput.render.elments;

import me.ulrichBarnstedt.libOutput.terminal.Cursor;

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
        int xItems = this.content.size();
        int yItems = 0;

        for (ArrayList<Element> row : this.content)
            if (row.size() > yItems) yItems = row.size();

        int innerHeight = this.sizeTable.getAxisSum().getY() + yItems - 1;
        int innerWidth = this.sizeTable.getAxisSum().getX() + xItems - 1;
        this.height = innerHeight + borderChange;
        this.width  = innerWidth + borderChange;
    }

    private ArrayList<Integer> extractIntersections (ArrayList<Integer> source) {
        ArrayList<Integer> intersections = new ArrayList<>();
        int offset = 0;

        for (int w : source) {
            offset += w + 1;
            intersections.add(offset);
        }

        return intersections;
    }

    private int verticalBar (int x, int y, int until, ArrayList<Integer> points) {
        for (int yLevel = 0; yLevel < until; yLevel++)
            for (int i = 0; i < points.size() - 1; i++)
                System.out.print(Cursor.toPos(x + points.get(i) - 1, y + yLevel) + this.boxDrawingStyle.getVERTICAL());

        return until;
    }

    private void intersectHorizontalBar (int x, int y, ArrayList<Integer> points, String character) {
        for (int p = 0; p < points.size() - 1; p++) {
            System.out.print(Cursor.toPos(x + points.get(p) - 1, y) + character);
        }
    }

    private void drawHorizontalBar (int x, int y, ArrayList<Integer> points) {
        String leftIntersect;
        String rightIntersect;

        if (this.showBorder) {
            leftIntersect = this.boxDrawingStyle.getLI();
            rightIntersect = this.boxDrawingStyle.getRI();
            x--;
        } else {
            leftIntersect = "";
            rightIntersect = "";
        }

        System.out.print(Cursor.toPos(x, y) + leftIntersect);

        int previous = 0;
        for (int p = 0; p < points.size(); p++) {
            for (int i = 0; i < points.get(p) - previous - 1; i++)
                System.out.print(this.boxDrawingStyle.getHORIZONTAL());

            System.out.print(p + 1 == points.size() ? rightIntersect : this.boxDrawingStyle.getCENTER());

            previous = points.get(p);
        }
    }

    @Override
    protected void renderBoxArtifacts (int x, int y) {
        ArrayList<Integer> xIntersections = this.extractIntersections(this.sizeTable.getXSum());
        ArrayList<Integer> yIntersections = this.extractIntersections(this.sizeTable.getYSum());

        if (this.showBorder) {
            x++;

            this.intersectHorizontalBar(x, y, xIntersections, this.boxDrawingStyle.getTI());
            y++;
        }

        y += this.verticalBar(x, y, yIntersections.get(0) - 1, xIntersections);

        for (int i = 0; i < yIntersections.size() - 1; i++) {
            this.drawHorizontalBar(x, y, xIntersections);
            y++;
            y += this.verticalBar(x, y, yIntersections.get(i + 1) - yIntersections.get(i) - 1, xIntersections);
        }

        if (this.showBorder) {
            this.intersectHorizontalBar(x, y, xIntersections, this.boxDrawingStyle.getBI());
        }
    }

    @Override
    protected void renderBoxContent (int x, int y) {
        for (int elementX = 0; elementX < this.content.size(); elementX++) {
            ArrayList<Element> col = this.content.get(elementX);
            int yOffset = 0;

            for (int elementY = 0; elementY < col.size(); elementY++) {
                col.get(elementY).render(x + this.paddingStyle.getL(), y + this.paddingStyle.getT() + yOffset);
                yOffset += this.sizeTable.getYSum().get(elementY) + 1;
            }

            x += this.sizeTable.getXSum().get(elementX) + 1;
        }
    }
}
