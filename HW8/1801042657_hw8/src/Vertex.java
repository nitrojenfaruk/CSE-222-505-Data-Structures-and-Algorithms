
/**
 * Vertex
 */
public class Vertex<E> {

    public static int count = -1;
    private int id;
    private String label;
    private double weight = 1.0;
    private E boostVal;

    /**
     * Default constructor
     */
    public Vertex(){}

    /**
     * @param label
     * @param weight
     */
    public Vertex(String label, double weight) {
        this.label = label;
        this.weight = weight;
        id = ++count;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the boostVal
     */
    public E getBoostVal() {
        return boostVal;
    }

    /**
     * @param boostVal the boostVal to set
     */
    public void setBoostVal(E boostVal) {
        this.boostVal = boostVal;
    }

    @Override
    public String toString() {
        return "id: " + id + ", weight: " + weight + ", label: " + label + ", boost  value: " + boostVal;
    }

}