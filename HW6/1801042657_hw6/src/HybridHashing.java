
/**
 * HybridHashing Class
 */
public class HybridHashing<K, V> implements KWHashMap<K, V> {

    private Entry<K, V>[] table;
    private int numKeys;
    private int numDeletes;
    private static int CAPACITY = 10;
    private static final double LOAD_THRESHOLD = 0.75;
    private final Entry<K, V> DELETED = new Entry<K, V>(null, null);

    @SuppressWarnings("unchecked")
    public HybridHashing() {
        table = new Entry[CAPACITY];
    }

    private static class Entry<K, V> {

        int index = -1;
        private K key;
        private V value;
        private Entry<K, V> next;

        /**
         * @param key the key
         * @param value the value of key
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        /**
         * @return the next entry
         */
        public Entry<K, V> getNext() {
            return next;
        }

        /**
         * @param next the next entry to be assigned
         */
        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        /**
         * 
         * @return the index of an entry
         */
        public int getIndex() {
            return index;
        }

        /**
         * 
         * @param index the index of an entry
         */
        public void setIndex(int index) {
            this.index = index;
        }

    }
    
    @Override
    public V get(Object key) {
        int index = findKey(key);
        if (table[index] == null)
            return null;
        else
            return table[index].value;
    }

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /**
     * Finds the largest prime number smaller than 0.8 * table size.
     * 
     * @param bound the upper bound for prime number
     * @return the prime number or -1
     */
    private int findLargestPrime(int bound) {

        int flag = 0;

        for (int num = bound; num >= 2; num--) {
            flag = 0;
            for (int j = 2; j < bound / 2; j++) {
                if (num % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return num;
            }
        }

        return -1;
    }

    /**
     * Hash1 function for hashing.
     * 
     * @param key The key value to be added
     * @return    hashcode of key % table length
     */
    private int h1(Object key) {
        return key.hashCode() % table.length;
    }

    /**
     * Hash2 function for hashing.
     * 
     * @param key      the key value to be added
     * @param primeNum the prime number
     * @return         prime Number - (hashcode of key % prime number)
     */
    private int h2(Object key, int primeNum) {
        return primeNum - (key.hashCode() % primeNum);
    }

    @Override
    public V put(K key, V value) {

        int i = 1;
        int index = 0;
        int firstPos = 0;

        double x = 0.8 * table.length;
        if (x - (long) x != 0) // fractional part
            x++;

        int bound = ((int) x - 1);
        int primeNum = findLargestPrime(bound);

        /* Position calculation */
        firstPos = (h1(key) + i * h2(key, primeNum)) % table.length;    

        if (table[firstPos] == null) {
            table[firstPos] = new Entry<K, V>(key, value);
            numKeys++;
            double load = (double) (numDeletes + numKeys) / table.length;
            if (load > LOAD_THRESHOLD) {
                rehash();
            }
            return null;
        }

        index = firstPos;
        while (table[index] != null) {
            i++;
            index = (h1(key) + i * h2(key, primeNum)) % table.length;
            if (index < 0 || index > table.length) {
                return null;
            }
        }

        table[index] = new Entry<K, V>(key, value);
        numKeys++;

        while (table[firstPos].getNext() != null) {
            firstPos = table[firstPos].getNext().getIndex();
        }
        table[firstPos].setNext(new Entry<K, V>(key, value));
        table[firstPos].getNext().setIndex(index);

        /* rehash */
        double load = (double) (numDeletes + numKeys) / table.length;
        if (load > LOAD_THRESHOLD) {
            rehash();
        }

        return null;
    }

    @Override
    public V remove(Object key) {

        V returnVal = null;
        int i = searchKey(key);
        int k = i;

        if (i == -1) 
            return null;

        if (table[i] == null) {
            return null;
        } else if (table[i] != null) {

            if (table[i].getNext() == null) {
                returnVal = table[i].value;
                table[i] = DELETED;
            } else if (table[table[i].getNext().getIndex()].getNext() == null) {
                int index = table[i].getNext().getIndex();
                table[i] = table[index];
                table[index] = DELETED;
            } else {
                int index = 0;
                while (table[i].getNext() != null) {
                    index = table[i].getNext().getIndex();
                    table[i] = table[index];
                    table[index] = table[index].getNext();
                    i = index;
                }
                table[table[k].getNext().getIndex()] = DELETED;
                table[k].next = null;
            }
            numKeys--;
            numDeletes++;

        }
        return returnVal;
    }

    @Override
    public int size() {
        return numKeys;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hash Value    Key   Next \n");

        for (int i = 0; i < table.length; i++) {
            stringBuilder.append("    " + i);
            if (table[i] == DELETED) {
                stringBuilder.append("               null");
            } else if (table[i] != null) {
                if (table[i].key != null)
                    stringBuilder.append("         " + table[i].key + "    ");
                else {
                    stringBuilder.append("     ");
                }

                if (table[i].getNext() != null)
                    stringBuilder.append("  " + table[i].getNext().getIndex());
                else {
                    stringBuilder.append("null");
                }
            }

            else {
                stringBuilder.append("               null");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    /**
     * Find the index of the key on table for get operation.
     * 
     * @param key the key to be searched
     * @return    the index of the key
     */
    private int findKey(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        return index;
    }

    /**
     * Search the index of the given key on table for remove operation.
     * 
     * @param key the to be searched
     * @return    the index of key or -1 (fail)
     */
    private int searchKey(Object key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (key == table[i].key) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Rehash the table according to the table length.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {

        Entry<K, V>[] oldtable = table;
        table = new Entry[2 * oldtable.length];

        numDeletes = 0;
        numKeys = 0;

        for (int i = 0; i < oldtable.length; i++) {
            if (oldtable[i] != null && oldtable[i] != DELETED) {
                put(oldtable[i].key, oldtable[i].value);
            }
        }
    }

    
}