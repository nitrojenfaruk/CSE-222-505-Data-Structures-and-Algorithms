import java.util.Arrays;

/**
 * It is created for converting binary tree to binary search tree 
 */
public class BtToBst {
    
	int index = 0;  // array index indicator

    /**
     * It takes a binary tree and an array of items as input, and it returns
     * a binary search tree (BST) with the same structure of binary tree and
     * items of the array as output. 
     * 
     * @param <T>
     * @param bTree the binary tree
     * @param arr   the array
     * @return      the generated binary search tree
     * @throws NullPointerException if array is empty
     */
    public <T extends Comparable<T>> BinaryTree<T> convertToBst(BinaryTree<T> bTree, T[] arr) throws NullPointerException{

        if(arr.length == 0 || arr[0] == null)
            throw new NullPointerException();

        if (bTree == null)
            return null;

        BinarySearchTree<T> bSearchTree = new BinarySearchTree<>();   
        Arrays.sort(arr);   // sorting the array

        /* in-order traversing */
        convertToBst(bTree.getLeftSubtree(), arr);
        bTree.root.data = arr[index++];   
        convertToBst(bTree.getRightSubtree(), arr);

        /* adding nodes to binary search tree */
        addNodesToBST(bTree.root, bSearchTree);

        return bSearchTree;
    }
    
    /**
     * Adds nodes of binary tree to the binary search tree.
     * 
     * @param <T>
     * @param root        the root of the binary tree
     * @param bSearchTree the binary search tree
     */
    private <T extends Comparable<T>> void addNodesToBST(BinaryTree.Node<T> root, BinarySearchTree<T> bSearchTree) {

        /* base case */
        if (root == null)
            return;

        bSearchTree.add(root.data);
        
        /* traversing the binary tree nodes */
        addNodesToBST(root.left, bSearchTree);
        addNodesToBST(root.right, bSearchTree);

    }
    
}
