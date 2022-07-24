import java.util.Arrays;

/**
 * Main Class
 * @author Sefa
 *
 */
public class Main {
    public static <T> void main(String[] args) throws Exception {

        /* ---------------- QUESTION 1 ------------------- */

        Integer[] arr = new Integer[9];
        Integer[] arr2 = new Integer[5];
        Integer[] arr3 = new Integer[5];
        Integer[] arr4 = new Integer[1];
        Integer[] arr7 = new Integer[20];
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();

        bTree.root = new BinaryTree.Node<Integer>(5);
        bTree.root.left = new BinaryTree.Node<Integer>(10);
        bTree.root.left.left = new BinaryTree.Node<Integer>(15);
        bTree.root.left.right = new BinaryTree.Node<Integer>(20);
        bTree.root.left.right.left = new BinaryTree.Node<Integer>(25);
        bTree.root.left.right.right = new BinaryTree.Node<Integer>(30);
        bTree.root.right = new BinaryTree.Node<Integer>(35);
        bTree.root.right.right = new BinaryTree.Node<Integer>(40);
        bTree.root.right.right.left = new BinaryTree.Node<Integer>(50);
        for (int i = 0; i < arr.length; i++) { // 9,8,7,...1
            arr[i] = arr.length - i;
        }

        BinaryTree<Integer> bTree2 = new BinaryTree<Integer>();

        bTree2.root = new BinaryTree.Node<Integer>(5);
        bTree2.root.left = new BinaryTree.Node<Integer>(10);
        bTree2.root.left.left = new BinaryTree.Node<Integer>(15);
        bTree2.root.right = new BinaryTree.Node<Integer>(20);
        bTree2.root.right.right = new BinaryTree.Node<Integer>(25);
        for (int i = 0; i < arr3.length; i++) { // 5,4,...1
            arr3[i] = arr3.length - i;
        }


        BinaryTree<Integer> bTree3 = new BinaryTree<Integer>();
        bTree3.root = new BinaryTree.Node<Integer>(4);

        arr4[0] = 14;  // 14 


        BinaryTree<Integer> bTree7 = new BinaryTree<Integer>();
        arr7[0] = 12; arr7[1] = 3; arr7[2] = 98; arr7[3] = 51; arr7[4] = 45; arr7[5] = 35;
        arr7[6] = 18; arr7[7] = 2; arr7[8] = 50; arr7[9] = 75; arr7[10] = 61;arr7[11] = 58;
        arr7[12] = 14; arr7[13] = 24; arr7[14] = 88; arr7[15] = 5; arr7[16] = 15; 
        arr7[17] = 1; arr7[18] = 200; arr7[19] = 29;

        bTree7.root = new BinaryTree.Node<Integer>(5);
        bTree7.root.right = new BinaryTree.Node<Integer>(10);
        bTree7.root.right.right = new BinaryTree.Node<Integer>(15);
        bTree7.root.right.right.right = new BinaryTree.Node<Integer>(20);
        bTree7.root.right.right.right.right = new BinaryTree.Node<Integer>(25);
        bTree7.root.right.right.right.right.right = new BinaryTree.Node<Integer>(30);
        bTree7.root.right.right.right.right.right.right = new BinaryTree.Node<Integer>(35);
        bTree7.root.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(40);
        bTree7.root.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(45);
        bTree7.root.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(50);
        bTree7.root.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(55);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(60);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(65);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(70);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(75);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(80);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(85);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(90);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(95);
        bTree7.root.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right.right = new BinaryTree.Node<Integer>(100);

        
        System.out.println("BINARY TREE");
        System.out.println("-----------");
        System.out.println(bTree);
        System.out.println("BINARY SEARCH TREE");
        System.out.println("------------------");
        BtToBst obj = new BtToBst();    
        BtToBst obj2 = new BtToBst();    
        BtToBst obj3 = new BtToBst();    
        BtToBst obj4 = new BtToBst();    
        BtToBst obj7 = new BtToBst();    
        
        try {
            System.out.println("Array : " + Arrays.toString(arr) + "\n");
            System.out.println(obj.convertToBst(bTree, arr));


            System.out.println("BINARY TREE");
            System.out.println("-----------");
            System.out.println(bTree2);
            System.out.println("BINARY SEARCH TREE");
            System.out.println("------------------");
            System.out.println("Array :" + Arrays.toString(arr3) + "\n");
            System.out.println(obj3.convertToBst(bTree2, arr3));

           
            System.out.println("BINARY TREE");
            System.out.println("-----------");
            System.out.println(bTree3);
            System.out.println("BINARY SEARCH TREE");
            System.out.println("------------------");
            System.out.println("Array :" + Arrays.toString(arr4) + "\n");
            System.out.println(obj4.convertToBst(bTree3, arr4));


            System.out.println("BINARY TREE");
            System.out.println("-----------");
            System.out.println(bTree7);
            System.out.println("BINARY SEARCH TREE");
            System.out.println("------------------");
            System.out.println("Array :" + Arrays.toString(arr7) + "\n");
            System.out.println(obj7.convertToBst(bTree7, arr7));

            System.out.println("BINARY TREE");
            System.out.println("-----------");
            System.out.println(bTree2);
            System.out.println("BINARY SEARCH TREE");
            System.out.println("------------------");
            System.out.println("Array :" + Arrays.toString(arr2) + "\n");
            System.out.println(obj2.convertToBst(bTree2, arr2));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

 
        /* ---------------- QUESTION 2 ------------------- */
        System.out.println("\n\nQUESTİON 2");
        System.out.println("----------\n");

        BstToAvl q = new BstToAvl();

        BinarySearchTree<Integer> bstree2 = new BinarySearchTree<>();

        bstree2.root = new BinarySearchTree.Node<Integer>(30);
        bstree2.root.left = new BinarySearchTree.Node<Integer>(20);
        bstree2.root.left.left = new BinarySearchTree.Node<Integer>(10);
        
        System.out.println("BINARY SEARCH TREE");
        System.out.println("------------------");
        System.out.println(bstree2);
        System.out.println("AVL TREE");
        System.out.println("--------");
        System.out.println(q.wrapperConvertToAvl(bstree2)); 



        BinarySearchTree<Integer> bstree3 = new BinarySearchTree<>();

        bstree3.root = new BinarySearchTree.Node<Integer>(10);
        bstree3.root.right = new BinarySearchTree.Node<Integer>(20);
        bstree3.root.right.right = new BinarySearchTree.Node<Integer>(30);
     
        System.out.println("BINARY SEARCH TREE");
        System.out.println("------------------");
        System.out.println(bstree3);
        System.out.println("AVL TREE");
        System.out.println("--------");
        System.out.println(q.wrapperConvertToAvl(bstree3));



        BinarySearchTree<Integer> bstree4 = new BinarySearchTree<>();

        bstree4.root = new BinarySearchTree.Node<Integer>(10);
        bstree4.root.right = new BinarySearchTree.Node<Integer>(30);
        bstree4.root.right.left = new BinarySearchTree.Node<Integer>(20);
     
        System.out.println("BINARY SEARCH TREE");
        System.out.println("------------------");
        System.out.println(bstree4);
        System.out.println("AVL TREE");
        System.out.println("--------");
        System.out.println(q.wrapperConvertToAvl(bstree4));



        BinarySearchTree<Integer> bstree5 = new BinarySearchTree<>();

        bstree5.root = new BinarySearchTree.Node<Integer>(30);
        bstree5.root.left = new BinarySearchTree.Node<Integer>(10);
        bstree5.root.left.right = new BinarySearchTree.Node<Integer>(20);

        System.out.println("BINARY SEARCH TREE");
        System.out.println("------------------");
        System.out.println(bstree5);
        System.out.println("AVL TREE");
        System.out.println("--------");
        System.out.println(q.wrapperConvertToAvl(bstree5));

        

        BinarySearchTree<Integer> bstree = new BinarySearchTree<>();

        bstree.root = new BinarySearchTree.Node<Integer>(10);
        bstree.root.left = new BinarySearchTree.Node<Integer>(5);
        bstree.root.left.left = new BinarySearchTree.Node<Integer>(2);
        bstree.root.left.right = new BinarySearchTree.Node<Integer>(8);
        bstree.root.left.right.left = new BinarySearchTree.Node<Integer>(7);
        bstree.root.left.right.left.left = new BinarySearchTree.Node<Integer>(6);
        bstree.root.right = new BinarySearchTree.Node<Integer>(16);
        bstree.root.right.right = new BinarySearchTree.Node<Integer>(20);
        bstree.root.right.right.left = new BinarySearchTree.Node<Integer>(18);

        System.out.println("BINARY SEARCH TREE");
        System.out.println("------------------");
        System.out.println(bstree);
        System.out.println("AVL TREE");
        System.out.println("--------");
        System.out.println(q.wrapperConvertToAvl(bstree));



        BinarySearchTree<Integer> bstree6 = new BinarySearchTree<>();

        bstree6.root = new BinarySearchTree.Node<Integer>(50);
        bstree6.root.left = new BinarySearchTree.Node<Integer>(30);
        bstree6.root.left.left = new BinarySearchTree.Node<Integer>(10);
        bstree6.root.left.left.left = new BinarySearchTree.Node<Integer>(5);
        bstree6.root.left.left.right = new BinarySearchTree.Node<Integer>(15);
        bstree6.root.right = new BinarySearchTree.Node<Integer>(70);
        bstree6.root.right.right = new BinarySearchTree.Node<Integer>(90);
        bstree6.root.right.right.right = new BinarySearchTree.Node<Integer>(110);

        System.out.println("BINARY SEARCH TREE");
        System.out.println("------------------");
        System.out.println(bstree6);
        System.out.println("AVL TREE");
        System.out.println("--------");
        System.out.println(q.wrapperConvertToAvl(bstree6));



        BinarySearchTree<Integer> bstree7 = new BinarySearchTree<>();

        bstree7.root = new BinarySearchTree.Node<Integer>(10);
        bstree7.root.left = new BinarySearchTree.Node<Integer>(5);
        bstree7.root.right = new BinarySearchTree.Node<Integer>(20);

        System.out.println("BINARY SEARCH TREE");
        System.out.println("------------------");
        System.out.println(bstree7);
        System.out.println("AVL TREE");
        System.out.println("--------");
        System.out.println(q.wrapperConvertToAvl(bstree7));

    }

   

}
