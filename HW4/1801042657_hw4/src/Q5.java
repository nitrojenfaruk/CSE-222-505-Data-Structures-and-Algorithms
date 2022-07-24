
/**
 * 
 * Question 5
 *
 */
public class Q5 {

    /**
     * Recursive function that calculates all the possible configurations to fill
     * 1-D array with colored-blocks.
     * 
     * @param arr      the 1D array
     * @param begin    the begin indicates beginning position of added blocks
     * @param tmpBegin the tmpBegin holds actual beginning of blocks to move right
     *                 one unit
     * @param index    the index is used for traversing the array
     * @param space    the space holds space number between blocks
     * @param blockNum the blockNum is incremented one by one to fill array
     */
    public void fillArray(char[] arr, int begin, int tmpBegin, int index, int space, int blockNum) {

        if (blockNum < 3 || arr.length < 3 || blockNum > arr.length) {
            System.out.println("--Invalid value!");
            return;
        }

        if (index - begin < blockNum)
            arr[index++] = 'X';

        if (index - begin == blockNum) {
            for (int i = 0; i < arr.length; i++) { // printing arr..
                System.out.print(" " + arr[i] + " " + "|");
            }
            System.out.println();
            if (blockNum <= (arr.length - index - space)) {
                index += space;
                begin = index;
            } else {
                for (int i = blockNum + tmpBegin; i < arr.length; i++) { // clear array except first blocks
                    arr[i] = ' ';
                }
                space++;
                if (index >= arr.length || blockNum + tmpBegin < arr.length) { // move head part one block to the right
                    for (int i = 0; i < arr.length; i++) { // clear old blocks
                        arr[i] = ' ';
                    }
                    tmpBegin++;
                    begin = tmpBegin;
                    space = 1;
                } else {
                    begin = blockNum + space + tmpBegin;
                }
                index = begin;
            }

        }

        /* Changing block number and begin position */
        if (tmpBegin + blockNum > arr.length && blockNum != arr.length) {
            tmpBegin = 0;
            begin = tmpBegin;
            index = begin;
            fillArray(arr, begin, tmpBegin, index, space, ++blockNum);
        }

        /* Recursive call for remaining part */
        else if (index < arr.length || blockNum < arr.length) {
            fillArray(arr, begin, tmpBegin, index, space, blockNum);
        }

        return;

    }
    
}
