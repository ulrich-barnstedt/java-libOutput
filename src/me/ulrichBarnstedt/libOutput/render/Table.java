package me.ulrichBarnstedt.libOutput.render;

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

        System.out.print("ySum: ");
        for (int i : this.sizeTable.getYSum()) {
            System.out.print(i + "; ");
        }
        System.out.print("\n");
        System.out.println("SIZE: " + this.sizeTable.getAxisSum().getX() + " | " + this.sizeTable.getAxisSum().getY());
    }

    @Override
    protected void renderBoxArtifacts (int x, int y) {}

    @Override
    protected void renderBoxContent (int x, int y) {

    }
}
