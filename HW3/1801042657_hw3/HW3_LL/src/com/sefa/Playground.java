package com.sefa;


/**
 * It represents playground. A playground have length and default height value (2).
 */
public class Playground implements City {

    private static int playgroundNum = 0;
    private static int playgroundLength = 0;
    private int position;
    private int length;
    private static final int HEIGHT = 2;

    @Override
    public int getLength() {
        return length;
    }

    /**
     * @return the height
     */
    public static int getHeight() {
        return HEIGHT;
    }

    /**
     * @return the playgroundNum
     */
    public static int getPlaygroundNum() {
        return playgroundNum;
    }

    /**
     * @param playgroundNum the playgroundNum to set
     */
    public static void setPlaygroundNum(int playgroundNum) {
        Playground.playgroundNum = playgroundNum;
    }

    /**
     * @return the playgroundNum
     */
    public static int getPlaygroundLength() {
        return playgroundLength;
    }

    /**
     * @param playgroundLength the playgroundLength to set
     */
    public static void setPlaygroundLength(int playgroundLength) {
        Playground.playgroundLength = playgroundLength;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @param position
     * @param length
     */
    public Playground(int position, int length) {
        this.position = position;
        setLength(length);
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Playground [position=" + position + ", length=" + length + ", height=" + HEIGHT + "]";
    }

}