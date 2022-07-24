
/**
 * It represents office building. A office have job type and owner.
 */
public class Office extends Building {

    private String jobType;
    private String owner;

    /**
     * @param position
     * @param length
     * @param height
     * @param jobType
     * @param owner
     */
    public Office(int position, int length, int height,
            String jobType, String owner) {
        super(position, length, height);
        this.jobType = jobType;
        this.owner = owner;
    }

    /**
     * @return the jobType
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * @param jobType the jobType to set
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
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
        return "Office [position=" + getPosition() + ", length=" + getLength() + ", height=" + getHeight()
                + ", jobType=" + jobType + ", owner=" + owner + "]";
    }

}