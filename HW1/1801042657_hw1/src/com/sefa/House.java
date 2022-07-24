
/**
 * It represents house building. A house have rooms, color and owner.
 */
public class House extends Building {

    private int numberOfRooms;
    private String color;
    private String owner;

    /**
     * @param position
     * @param length
     * @param height
     * @param numberOfRooms
     * @param color
     * @param owner
     */
    public House(int position, int length, int height,
            int numberOfRooms, String color, String owner) {
        super(position, length, height);
        this.numberOfRooms = numberOfRooms;
        this.color = color;
        this.owner = owner;
    }

    /**
     * @return the numberOfRooms
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * @param numberOfRooms the numberOfRooms to set
     */
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "House [position=" + getPosition() + ", length=" + getLength() + ", height=" + getHeight()
                + ", numberOfRooms=" + numberOfRooms
                + ", color=" + color + ", owner=" + owner + "]";
    }

}