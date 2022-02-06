package ulrichbarnstedt.lib.output.render.elments;

import ulrichbarnstedt.lib.output.render.style.PaddingStyle;
import ulrichbarnstedt.lib.output.util.Pair;

import java.util.ArrayList;

class SizeLayout {
    private ArrayList<Integer> ySum;
    private ArrayList<Integer> xSum;
    private ArrayList<ArrayList<Pair<Integer, Integer>>> sizes;
    private Pair<Integer, Integer> axisSum;
    private PaddingStyle elementPadding;

    public SizeLayout (PaddingStyle elementPadding) {
        this.ySum = new ArrayList<>();
        this.xSum = new ArrayList<>();
        this.sizes = new ArrayList<>();
        this.axisSum = new Pair<>(0, 0);
        this.elementPadding = elementPadding;
    }

    private void checkSize (int x, int y) {
        while (this.sizes.size() - 1 < x)
            this.sizes.add(new ArrayList<>());

        while (this.sizes.get(x).size() - 1 < y)
            this.sizes.get(x).add(new Pair<>(0, 0));
    }

    public void recalculate (ArrayList<ArrayList<Element>> elements) {
        int widthSum = 0;
        int heightSum = 0;

        for (int x = 0; x < elements.size(); x++) {
            int widestElement = 0;
            ArrayList<Element> col = elements.get(x);

            for (int y = 0; y < col.size(); y++) {
                Element e = col.get(y);
                int width = e.totalWidth() + elementPadding.getR() + elementPadding.getL();
                int height = e.totalHeight() + elementPadding.getT() + elementPadding.getB();

                this.checkSize(x, y);
                this.sizes.get(x).get(y).set(width, height);

                if (width > widestElement) widestElement = width;
            }

            if (this.xSum.size() - 1 < x) this.xSum.add(0);
            this.xSum.set(x, widestElement);

            widthSum += widestElement;
        }

        // calculate maxima
        int yMax = 0;
        int xMax = this.sizes.size();
        for (ArrayList<Element> col : elements)
            if (col.size() > yMax)
                yMax = col.size();

        for (int y = 0; y < yMax; y++) {
            int highestElement = 0;

            for (int x = 0; x < xMax; x++) {
                if (y >= this.sizes.get(x).size()) continue;

                ArrayList<Pair<Integer, Integer>> col = this.sizes.get(x);
                if (col.get(y).getY() > highestElement) highestElement = col.get(y).getY();
            }

            if (this.ySum.size() <= y)
                this.ySum.add(highestElement);
            else
                this.ySum.set(y, highestElement);

            heightSum += highestElement;
        }

        this.axisSum.set(widthSum, heightSum);
    }

    public ArrayList<Integer> getYSum () {
        return ySum;
    }

    public ArrayList<Integer> getXSum () {
        return xSum;
    }

    public ArrayList<ArrayList<Pair<Integer, Integer>>> getSizes () {
        return sizes;
    }

    public Pair<Integer, Integer> getAxisSum () {
        return this.axisSum;
    }

    public void setElementPadding (PaddingStyle elementPadding) {
        this.elementPadding = elementPadding;
    }
}
