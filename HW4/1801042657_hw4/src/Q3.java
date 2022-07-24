
/**
 * 
 * Question 3
 *
 */
public class Q3 {
    
    /**
     * Recursive function to find contiguous subarray/s that the sum of its/theirs
     * items is equal to a given integer value.
     * 
     * @param items  the unsorted integer array 
     * @param begin  the beginning of subarray
     * @param index  the index traverses in items
     * @param sum    the sum is used for sum value in subarray
     * @param target the target sum that given by user
     */
    public void targetSum(int items[], int begin, int index, int sum, int target) {

        if (begin >= items.length)
            return;

        if (sum > target) {
            begin++;
            index = begin;
            sum = 0;
            targetSum(items, begin, index, sum, target);
        } else if (sum == target) {
            int bound = (index == items.length - 1 && sum - items[index] == target) ? (index + 1) : index;
            for (int i = begin; i < bound; i++) { // printing subarray -> no violation to recursion
                System.out.print(items[i] + " ");
            }
            System.out.println();
            if (index != items.length - 1) {
                sum += items[index];
                index++;
            } else if (index == items.length - 1) {
                begin++;
                index = begin;
                sum = 0;
            }
            targetSum(items, begin, index, sum, target);
        } else { // sum < target
            sum += items[index];
            if (begin == items.length - 1 && sum == target)
                System.out.print(sum);
            else if (begin == items.length - 1 && sum != target)
                return;
            if (index != items.length - 1)
                index++;
            if (index == items.length - 1 && begin == items.length - 2 && sum != target) {
                begin++;
                index = begin;
                sum = 0;
            }
            targetSum(items, begin, index, sum, target);
        }
        return;
    }
    
}
