package me.ulrichBarnstedt.libOutput.render;

import java.util.ArrayList;

interface SizeHelperFn {
    int run(Element e);
}

class SizeHelper {
    /*
    static int height (ArrayList<ArrayList<Element>> elements, SizeHelperFn heightFn) {
        int height = 0;

        for (ArrayList<Element> col : elements) {
            int maxRowHeight = 0;

            for (Element e : col) {
                int eHeight = heightFn.run(e);
                if (eHeight > maxRowHeight) maxRowHeight = eHeight;
            }

            height += maxRowHeight;
        }

        return height;
   }

    static int width (ArrayList<ArrayList<Element>> elements, SizeHelperFn widthFn) {
        int maxWidth = 0;

        for (ArrayList<Element> col : elements) {
            int rowWidth = 0;

            for (Element e : col)
                rowWidth += widthFn.run(e);

            if (rowWidth > maxWidth) maxWidth = rowWidth;
        }

        return maxWidth;
    }
    */


    static int height (ArrayList<ArrayList<Element>> elements, SizeHelperFn heightFn) {
        int maxHeight = 0;

        for (ArrayList<Element> col : elements) {
            int colHeight = 0;

            for (Element e : col)
                colHeight += heightFn.run(e);

            if (colHeight > maxHeight) maxHeight = colHeight;
        }

        return maxHeight;
    }

    static int width (ArrayList<ArrayList<Element>> elements, SizeHelperFn widthFn) {
        int width = 0;

        for (ArrayList<Element> col : elements) {
            int maxRowWidth = 0;

            for (Element e : col) {
                int eWidth = widthFn.run(e);
                if (eWidth > maxRowWidth) maxRowWidth = eWidth;
            }

            width += maxRowWidth;
        }

        return width;
    }
}
