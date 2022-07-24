/**
 * HashTableChain
 */
public class HashTableChain<K extends Comparable<K>, V> implements KWHashMap<K, V> {

    private BinarySearchTree<Entry<K, V>>[] table;
    private int numKeys = 0;
    private static final int CAPACITY = 10;
    private static final double LOAD_THRESHOLD = 0.75;

    @SuppressWarnings("unchecked")
    public HashTableChain() {
        table = new BinarySearchTree[getCapacity()];
    }

    /**
     * @return the capacity of table
     */
    public static int getCapacity() {
        return CAPACITY;
    }

    /**
     * @return the load thresholds
     */
    public static double getLoad() {
        return LOAD_THRESHOLD;
    }

    private static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {

        private K key;
        private V value;

        /**
         * 
         * @param key   the key parameter
         * @param value the value of key
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * 
         * @return the key
         */
        public K getKey() {
            return key;
        }

        /**
         * 
         * @return the value
         */
        public V getValue() {
            return value;
        }

        /**
         * 
         * @param val the new value
         * @return the old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }

        @Override
        public int compareTo(Entry<K, V> o) {
            return key.compareTo(o.getKey());
        }
    }

    @Override
    public V get(Object key) {

        int index = findKey(key);
        if (table[index] == null)
            return null; // Key is not in the table

        BSTIterator<Entry<K, V>> iter = new BSTIterator<>(table[index].root);
        while (iter.hasNext()) {
            Entry<K, V> item = iter.next();
            if (item.key.equals(key))   // Key is found
                return item.value;
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public V put(K key, V value) {

        int index = key.hashCode() % table.length;

        if (index < 0)
            index += table.length;

        if (table[index] == null) 
            table[index] = new BinarySearchTree<>();

        BSTIterator<Entry<K, V>> iter = new BSTIterator<>(table[index].root);
        while (iter.hasNext()) {
            Entry<K, V> item = iter.next();
            if (item.key.equals(key)) {
                V oldVal = item.getValue();
                item.setValue(value);
                return oldVal;
            }
        }

        /* New key-value pair */
        table[index].add(new Entry<>(key, value));
        numKeys++;

        /* rehash */
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();

        return null;
    }

    @Override
    public V remove(Object key) {

        int index = findKey(key);

        if (table[index] == null)
            return null;

        BSTIterator<Entry<K, V>> iter = new BSTIterator<>(table[index].root);
        while (iter.hasNext()) {
            Entry<K, V> item = iter.next();
            if (item.key.equals(key)) {     // Key is found
                table[index].remove(item);
                numKeys--;
                return item.getValue();
            }
        }

        return null;
    }

    @Override
    public int size() {
        return numKeys;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (table[i].root != null) {
                    preOrderTraverse(table[i].root, 1, sb);
                }
            }
        }

        return sb.toString();
    }

    /**
     * Pre-order traverse the BST.
     * 
     * @param root  the root of BST
     * @param depth the depth of tree
     * @param sb    the string builder
     */
    private void preOrderTraverse(BinaryTree.Node<Entry<K, V>> root, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("    "); // indentation
        }
        if (root == null) {
            sb.append("null\n");
        } else {
            sb.append(root.toString());
            sb.append("\n");
            preOrderTraverse(root.left, depth + 1, sb);
            preOrderTraverse(root.right, depth + 1, sb);
        }
    }

    /**
     * Rehash the table if number of keys exceed load factor * table length.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        BinarySearchTree<Entry<K, V>>[] newBST = new BinarySearchTree[table.length * 2];

        for (BinarySearchTree<Entry<K, V>> tree : table) {
            if (tree != null) {
                BSTIterator<Entry<K, V>> iter = new BSTIterator<>(tree.root);
                while (iter.hasNext()) {
                    Entry<K, V> item = iter.next();
                    int index = item.getKey().hashCode() % newBST.length;

                    if (index < 0)
                        index += table.length;

                    if (newBST[index] == null)
                        newBST[index] = new BinarySearchTree<>();

                    newBST[index].add(item);
                }
            }

        }
        table = newBST;
    }

    /**
     * Find the index of the key on table for get/remove operations.
     * 
     * @param key the key to be searched
     * @return the index of the key
     */
    private int findKey(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        return index;
    }
}