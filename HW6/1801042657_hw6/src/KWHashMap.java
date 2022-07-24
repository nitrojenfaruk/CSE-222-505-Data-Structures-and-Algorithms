
/**
 * KWHashMap
 */
public interface KWHashMap<K, V> {
    /**
     * 
     * @param key The key object to be get
     * @return    The value asssociated with the specified key, or null
     */
    V get(Object key);

    /**
     * 
     * @return true if table contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * 
     * @param key   The key to be put
     * @param value The value to be put
     * @return      The previous value associated with the specified key, or null
     */
    V put(K key, V value);

    /**
     * 
     * @param key The key to be removed
     * @return    The previous value associated with the specified key, or null
     */
    V remove(Object key);

    /**
     * 
     * @return The size of the table
     */
    int size();
}