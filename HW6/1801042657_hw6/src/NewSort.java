
/**
 * NewSort Class
 */
public class NewSort<T extends Comparable<? super T>> {

    /**
     * MinMax class
     * It includes 2 integer for min value and max value index.
     */
    protected static class MinMax {
        int min;
        int max;
    }

    /**
     * Find indices of min and max value.
     * 
     * @param arr  The array to be traversed
     * @param low  The lower bound of the array
     * @param high The upper bound of the array
     * @return     The MinMax object that has min and max indices
     */
    private static <T extends Comparable<T>> MinMax min_max_finder(T[] arr, int low, int high) {

        MinMax minmax = new MinMax();
        MinMax minMaxLeft = new MinMax();
        MinMax minMaxRight = new MinMax();
        int mid;

        // There is only one element
        if (low == high) {
            minmax.max = low;
            minmax.min = low;
            return minmax;
        }

        // There are two elements
        if (high - low == 1) {
            if (arr[low].compareTo(arr[high]) == 1) {
                minmax.max = low;
                minmax.min = high;
            } else {
                minmax.max = high;
                minmax.min = low;
            }
            return minmax;
        }

        // There are more than 2 elements
        mid = (low + high) / 2;
        minMaxLeft = min_max_finder(arr, low, mid);
        minMaxRight = min_max_finder(arr, mid + 1, high);

        if (arr[minMaxLeft.min].compareTo(arr[minMaxRight.min]) == -1)
            minmax.min = minMaxLeft.min;
        else
            minmax.min = minMaxRight.min;

        if (arr[minMaxLeft.max].compareTo(arr[minMaxRight.max]) == 1)
            minmax.max = minMaxLeft.max;
        else
            minmax.max = minMaxRight.max;

        return minmax;
    }

    /**
     * Sort a part of the array (from head through tail) using the newSort algorithm.
     * post: The part of array from head through tail is sorted.
     * 
     * 
     * @param array The array to be sorted
     * @param head  The head of array to be sorted
     * @param tail  The tail of array to be sorted
     * @return The array that was sorted
     */
    public static <T extends Comparable<T>> T[] new_sort(T[] array, int head, int tail) {

        if (head > tail)
            return array;
        else {
            MinMax obj = min_max_finder(array, head, tail);
            swap(array, head, obj.min);
            swap(array, tail, obj.max);
            return new_sort(array, head + 1, tail - 1);
        }
    }

    /**
     * Swap the elements in array[first] and array[second].
     * 
     * @param array  The array that contains the items
     * @param first  The index of one item
     * @param second The index of the second item
     */
    private static <T extends Comparable<T>> void swap(T[] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
