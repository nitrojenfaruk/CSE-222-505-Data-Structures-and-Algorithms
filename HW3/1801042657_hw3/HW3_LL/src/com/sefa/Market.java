package com.sefa;


/**
 * It represents market building. A market have owner, opening and closing time.
 */
public class Market extends Building {

    private String owner;
    private int openingTime;
    private int closingTime;

    /**
     * @param position
     * @param length
     * @param height
     * @param owner
     * @param openingTime
     * @param closingTime
     */
    public Market(int position, int length, int height, String owner, int openingTime, int closingTime) {
        super(position, length, height);
        this.owner = owner;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the openingTime
     */
    public int getOpeningTime() {
        return openingTime;
    }

    /**
     * @param openingTime the openingTime to set
     */
    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    /**
     * @return the closingTime
     */
    public int getClosingTime() {
        return closingTime;
    }

    /**
     * @param closingTime the closingTime to set
     */
    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Office [position=" + getPosition() + ", length=" + getLength() + ", height=" + getHeight()
                + ", openingTime=" + openingTime + ", closingTime=" + closingTime + ", owner=" + owner + "]";
    }

}