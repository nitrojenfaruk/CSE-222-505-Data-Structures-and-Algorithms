
/**
 * 
 * Question 2
 *
 */
public class Q2 {

    /**
     * Wrapper function to find the number of items in the array between two
     * given integer values.
     * 
     * @param arr   the sorted integer array
     * @param begin the begin value indicates left bound
     * @param end   the end value indicates right bound
     * @return      the count of numbers
     */
    public int wrapperFindItems(int[] arr, int begin, int end) {
        int leftMid = ((begin + end) / 2);
        int rightMid = leftMid;
        int count = 0;
        return findItems(arr, begin, end, leftMid, rightMid, count);
    }

    /**
     * Recursive function to find the number of items in the array between two
     * given integer values.
     * 
     * @param arr      the sorted integer array
     * @param begin    the begin value indicates left bound
     * @param end      the end value indicates right bound
     * @param leftMid  the left middle is used like an left parameter in binary
     *                 search algorithm
     * @param rightMid the right middle is used like an right parameter in binary
     *                 search algorithm
     * @param count    the count increments if number is between bounds
     * @return the count of numbers
     */
    private int findItems(int arr[], int begin, int end, int leftMid, int rightMid, int count) {

        if (rightMid <= end) {
            if (contain(arr, 0, arr.length - 1, rightMid) && leftMid != rightMid) {
                count++;
            }
            return findItems(arr, begin, end, leftMid, ++rightMid, count);
        }
        if (leftMid >= begin) {
            if (contain(arr, 0, arr.length - 1, leftMid)) {
                count++;
            }
            return findItems(arr, begin, end, --leftMid, rightMid, count);
        }
        return count;
    }

    /**
     * Recursive function that uses binary search algorithm to find given number.
     * 
     * @param arr       the sorted integer array
     * @param left      the left argument for left lower bound
     * @param right     the right argument for right upper bound
     * @param item      the number sought
     * @return          return true if found otherwise return false 
     */
    private boolean contain(int arr[], int left, int right, int item) {

        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == item)
                return true;
            if (arr[mid] > item)
                return contain(arr, left, mid - 1, item);
            return contain(arr, mid + 1, right, item);
        }
        return false;
    }
}
