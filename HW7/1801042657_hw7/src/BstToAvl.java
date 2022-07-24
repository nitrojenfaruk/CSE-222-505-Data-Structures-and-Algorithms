import java.util.ArrayList;
import java.util.List;

/**
 * It is created for converting binary search tree to AVL tree
 */
public class BstToAvl {

    /**
     * It is wrapper function for converting the binary search tree to AVL tree
     * 
     * @param <T>
     * @param bstree the binary search tree to be converted
     * @return the balanced binary search tree (AVL tree)
     */
    public <T extends Comparable<T>> BinarySearchTree<T> wrapperConvertToAvl(BinarySearchTree<T> bstree) {

        convertToAvl(bstree, bstree, bstree.root.data);
        return bstree;

    }

    /**
     * First and second parameter are the binary search tree. One is used for
     * recursive calls (sub-trees) and the other is used to find the parent of node
     * on the real binary tree. Last parameter is used to determine root of the
     * subtree
     * is the root of the exact binary tree or not.
     * 
     * @param <T>
     * @param bstree  the binary search tree - sub-trees -
     * @param realBST the real binary search tree
     * @param rootVal the value of the root of binary search tree
     */
    private <T extends Comparable<T>> void convertToAvl(BinarySearchTree<T> bstree, BinarySearchTree<T> realBST,
            T rootVal) {

        /* base case */
        if (bstree == null)
            return;

        /* post-order */
        convertToAvl(bstree.getLeftSubtree(), realBST, rootVal);
        convertToAvl(bstree.getRightSubtree(), realBST, rootVal);

        Integer balance = findBalance(bstree.root);

        // Left Left Case
        if (balance > 1 && findBalance(bstree.root.left) >= 0) {

            T tmpRoot = bstree.root.data; // root of the sub-tree
            bstree.root = rightRotate(bstree.root); // rotate the sub-tree

            /*
             * If the node is not the root of the exact tree,
             * parent of the node must point to the new root of the subtree
             */
            if (tmpRoot != rootVal) {
                List<Integer> result = new ArrayList<>();
                findParentNodeVal(realBST.root, (Integer) tmpRoot, -1, result); // finds parent node value
                int value = result.get(0);
                /*
                 * If the value of the parent node is less than the old root data,
                 * parent node must point to the right of itself, otherwise left.
                 */
                if ((Integer) realBST.findTarget(value).data < (Integer) bstree.root.data)
                    realBST.findTarget(value).right = bstree.root;
                else
                    realBST.findTarget(value).left = bstree.root;
            }
        }

        // Right Right Case
        if (balance < -1 && findBalance(bstree.root.right) <= 0) {
            T tmpRoot = bstree.root.data;
            bstree.root = leftRotate(bstree.root);
            if (tmpRoot != rootVal) {
                List<Integer> result = new ArrayList<>();
                findParentNodeVal(realBST.root, (Integer) tmpRoot, -1, result);
                int value = result.get(0);
                if ((Integer) realBST.findTarget(value).data < (Integer) bstree.root.data)
                    realBST.findTarget(value).right = bstree.root;
                else
                    realBST.findTarget(value).left = bstree.root;
            }
        }

        // Left Right Case
        if (balance > 1 && findBalance(bstree.root.left) == -1) {
            T tmpRoot = bstree.root.data;
            bstree.root.left = leftRotate(bstree.root.left);
            bstree.root = rightRotate(bstree.root);
            if (tmpRoot != rootVal) {
                List<Integer> result = new ArrayList<>();
                findParentNodeVal(realBST.root, (Integer) tmpRoot, -1, result);
                int value = result.get(0);
                if ((Integer) realBST.findTarget(value).data < (Integer) bstree.root.data)
                    realBST.findTarget(value).right = bstree.root;
                else
                    realBST.findTarget(value).left = bstree.root;
            }
        }

        // Right Left Case
        if (balance < -1 && findBalance(bstree.root.right) == 1) {
            T tmpRoot = bstree.root.data;
            bstree.root.right = rightRotate(bstree.root.right);
            bstree.root = leftRotate(bstree.root);
            if (tmpRoot != rootVal) {
                List<Integer> result = new ArrayList<>();
                findParentNodeVal(realBST.root, (Integer) tmpRoot, -1, result);
                int value = result.get(0);
                if ((Integer) realBST.findTarget(value).data < (Integer) bstree.root.data)
                    realBST.findTarget(value).right = bstree.root;
                else
                    realBST.findTarget(value).left = bstree.root;
            }

        }

    }

    /**
     * It finds the parent node value of the node with the given node value.
     * 
     * @param <T>
     * @param node   the root of the tree
     * @param value  the node value to be find its parent
     * @param parent the value of the parent
     * @param result the result includes parent value
     */
    private <T extends Comparable<T>> void findParentNodeVal(BinaryTree.Node<T> node, Integer value, Integer parent,
            List<Integer> result) {
        if (node == null)
            return;
        if ((Integer) node.data == value) {
            result.add((Integer) parent);
        } else {
            findParentNodeVal(node.left, value, (Integer) node.data, result);
            findParentNodeVal(node.right, value, (Integer) node.data, result);
        }
    }

    /**
     * Rotates the tree to the right for balancing. It returns the new root of the
     * sub-tree.
     * 
     * @param <T>
     * @param node the root of the sub-tree
     * @return the new root
     */
    private <T extends Comparable<T>> BinarySearchTree.Node<T> rightRotate(BinarySearchTree.Node<T> node) {

        BinarySearchTree.Node<T> root = node.left;

        node.left = root.right;
        root.right = node;

        return root;

    }

    /**
     * Rotates the tree to the left for balancing. It returns the new root of the
     * sub-tree.
     * 
     * @param <T>
     * @param node the root of the sub-tree
     * @return the new root
     */
    private <T extends Comparable<T>> BinarySearchTree.Node<T> leftRotate(BinarySearchTree.Node<T> node) {

        BinarySearchTree.Node<T> root = node.right;

        node.right = root.left;
        root.left = node;

        return root;
    }

    /**
     * Finds the height of the node with recursive calls for left and right subtree.
     * 
     * @param <T>
     * @param node the node to be found it's height
     * @return the height of the node
     */
    private <T extends Comparable<T>> Integer findHeight(BinarySearchTree.Node<T> node) {
        if (node == null)
            return -1;
        if (isLeaf(node))
            return 0;
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }

    /**
     * Subtracts the height of the right node of the node from left node.
     * 
     * @param <T>
     * @param node the node to be found it's balance value
     * @return the balance value
     */
    private <T extends Comparable<T>> Integer findBalance(BinarySearchTree.Node<T> node) {
        if (node == null)
            return 0;

        return findHeight(node.left) - findHeight(node.right);
    }

    /**
     * Finds whether the node is leaf or not.
     * 
     * @param <T>
     * @param node the node of the tree
     * @return true if node is leaf, otherwise false
     */
    private <T extends Comparable<T>> boolean isLeaf(BinarySearchTree.Node<T> node) {
        return (node.left == null && node.right == null);
    }

}
