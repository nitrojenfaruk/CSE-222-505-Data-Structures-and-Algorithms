package com.sefa;


/**
 * It consists of house, office and market. Ýt has own position and height
 * properties and length from City interface.
 */
public class Building implements City {

    private int position;
    private int height;
    private int length;

    /**
     * @param position
     * @param length
     * @param height
     */
    public Building(int position, int length, int height) {
        this.position = position;
        setLength(length);
        this.height = height;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Building [position=" + position + ", length=" + length + ", height=" + height + "]";
    }

}