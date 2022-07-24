import java.util.Stack;

/**
 * BSTIterator Class
 * Iterator for binary search tree.
 */
public class BSTIterator<E> extends BinaryTree<E> {

    private Node<E> root;
    private Stack<Node<E>> stack;

    /**
     * 
     * @param root the root of BST
     */
    public BSTIterator(Node<E> root) {
        this.root = root;
        stack = new Stack<>();
    }

    /**
     * 
     * @return the boolean value according to whether there is a next element in BST or not
     */
    public boolean hasNext() {
        return !stack.empty() || root != null;
    }

    /**
     * 
     * @return the next item in BST
     */
    public E next() {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        Node<E> nextItem = stack.pop();
        root = nextItem.right;
        return nextItem.data;
    }
}