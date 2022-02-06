package ulrichbarnstedt.lib.output.render.style;

/**
 * Class for representing styling of box drawing.
 * All setters are chainable.
 */
public class BoxStyle {
    private String VERTICAL;
    private String HORIZONTAL;
    private String LT;
    private String LB;
    private String RT;
    private String RB;
    private String LI;
    private String RI;
    private String BI;
    private String TI;
    private String CENTER;

    /**
     * Default box styling
     */
    public static BoxStyle defaultStyle () {
        return new BoxStyle("│", "─",
            "┌", "└",  "┘", "┐",
            "├", "┬", "┤", "┴",
            "┼");
    }

    /**
     * Characters used for box drawing
     * @param VERTICAL Vertical lines
     * @param HORIZONTAL Horizontal lines
     * @param LT Left top corner
     * @param LB Left bottom corner
     * @param RB Right bottom corner
     * @param RT Right top corner
     * @param LI Left intersection
     * @param TI Top intersection
     * @param RI Right intersection
     * @param BI Bottom intersection
     * @param CENTER Center intersection
     */
    public BoxStyle (String VERTICAL, String HORIZONTAL,
                     String LT, String LB, String RB, String RT,
                     String LI, String TI, String RI, String BI,
                     String CENTER) {
        this.VERTICAL = VERTICAL;
        this.HORIZONTAL = HORIZONTAL;
        this.LT = LT;
        this.LB = LB;
        this.RB = RB;
        this.RT = RT;
        this.LI = LI;
        this.TI = TI;
        this.RI = RI;
        this.BI = BI;
        this.CENTER = CENTER;
    }

    /**
     * Vertical line
     */
    public String getVERTICAL () {
        return VERTICAL;
    }

    /**
     * Vertical line
     */
    public BoxStyle setVERTICAL (String VERTICAL) {
        this.VERTICAL = VERTICAL;
        return this;
    }

    /**
     * Horizontal line
     */
    public String getHORIZONTAL () {
        return HORIZONTAL;
    }

    /**
     * Horizontal line
     */
    public BoxStyle setHORIZONTAL (String HORIZONTAL) {
        this.HORIZONTAL = HORIZONTAL;
        return this;
    }

    /**
     * Left top corner
     */
    public String getLT () {
        return LT;
    }

    /**
     * Left top corner
     */
    public BoxStyle setLT (String LT) {
        this.LT = LT;
        return this;
    }

    /**
     * Left bottom corner
     */
    public String getLB () {
        return LB;
    }

    /**
     * Left bottom corner
     */
    public BoxStyle setLB (String LB) {
        this.LB = LB;
        return this;
    }

    /**
     * Right top corner
     */
    public String getRT () {
        return RT;
    }

    /**
     * Right top corner
     */
    public BoxStyle setRT (String RT) {
        this.RT = RT;
        return this;
    }

    /**
     * Right bottom corner
     */
    public String getRB () {
        return RB;
    }

    /**
     * Right bottom corner
     */
    public BoxStyle setRB (String RB) {
        this.RB = RB;
        return this;
    }

    /**
     * Left intersection
     */
    public String getLI () {
        return LI;
    }

    /**
     * Left intersection
     */
    public BoxStyle setLI (String LI) {
        this.LI = LI;
        return this;
    }

    /**
     * Right intersection
     */
    public String getRI () {
        return RI;
    }

    /**
     * Right intersection
     */
    public BoxStyle setRI (String RI) {
        this.RI = RI;
        return this;
    }

    /**
     * Bottom intersection
     */
    public String getBI () {
        return BI;
    }

    /**
     * Bottom intersection
     */
    public BoxStyle setBI (String BI) {
        this.BI = BI;
        return this;
    }

    /**
     * Top intersection
     */
    public String getTI () {
        return TI;
    }

    /**
     * Top intersection
     */
    public BoxStyle setTI (String TI) {
        this.TI = TI;
        return this;
    }

    /**
     * Center intersection
     */
    public String getCENTER () {
        return CENTER;
    }

    /**
     * Center intersection
     */
    public BoxStyle setCENTER (String CENTER) {
        this.CENTER = CENTER;
        return this;
    }
}
