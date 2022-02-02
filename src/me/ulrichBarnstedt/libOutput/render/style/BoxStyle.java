package me.ulrichBarnstedt.libOutput.render.style;

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
    public void setVERTICAL (String VERTICAL) {
        this.VERTICAL = VERTICAL;
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
    public void setHORIZONTAL (String HORIZONTAL) {
        this.HORIZONTAL = HORIZONTAL;
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
    public void setLT (String LT) {
        this.LT = LT;
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
    public void setLB (String LB) {
        this.LB = LB;
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
    public void setRT (String RT) {
        this.RT = RT;
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
    public void setRB (String RB) {
        this.RB = RB;
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
    public void setLI (String LI) {
        this.LI = LI;
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
    public void setRI (String RI) {
        this.RI = RI;
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
    public void setBI (String BI) {
        this.BI = BI;
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
    public void setTI (String TI) {
        this.TI = TI;
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
    public void setCENTER (String CENTER) {
        this.CENTER = CENTER;
    }
}
