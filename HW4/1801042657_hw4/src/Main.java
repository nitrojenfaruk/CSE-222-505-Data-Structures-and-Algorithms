import java.util.Scanner;

/**
 * 
 * @author Sefa Cicek
 * Main Class
 *
 */
public class Main {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int choice;

            while (true) {
                System.out.println("\n1- Q1 -> a string in another bigger string");
                System.out.println("2- Q2 -> the number of items between two given integer values");
                System.out
                        .println("3- Q3 -> contiguous subarray/s that the sum of its items is equal to a given target");
                System.out.println("5- Q5 -> all possible configurations to fill 1D array with colored-blocks");
                System.out.println("6- Q6 -> snake game");
                System.out.println("0- Exit");
                System.out.println("\nChoose the problem: ");

                choice = Integer.parseInt(scan.nextLine());
                System.out.println();

                if (choice == 1) {
                    Q1 q1 = new Q1();
                    System.out.println("Found in the FIRST INDEX of the array");
                    System.out.println("-------------------------------------");
                    System.out.println("Small string: bbb");
                    System.out.println("Big string: bbbaaccbbbaaccbbb");
                    System.out.println("Target occurence: 1");
                    System.out.print("Result: ");
                    System.out.println(q1.searchString("bbb", "bbbaaccbbbaaccbbb", 0, 0, 1));

                    System.out.println("\nFound in the MIDDLE of the array");
                    System.out.println("-------------------------------------");
                    System.out.println("Small string: bbb");
                    System.out.println("Big string: bbbaaccbbbaaccbbb");
                    System.out.println("Target occurence: 2");
                    System.out.print("Result: ");
                    System.out.println(q1.searchString("bbb", "bbbaaccbbbaaccbbb", 0, 0, 2));

                    System.out.println("\nFound in the LAST PART of the array");
                    System.out.println("-------------------------------------");
                    System.out.println("Small string: bbb");
                    System.out.println("Big string: bbbaaccbbbaaccbbb");
                    System.out.println("Target occurence: 3");
                    System.out.print("Result: ");
                    System.out.println(q1.searchString("bbb", "bbbaaccbbbaaccbbb", 0, 0, 3));

                    System.out.println("\nTarget occurrence is less than 0");
                    System.out.println("-------------------------------------");
                    System.out.println("Small string: bbb");
                    System.out.println("Big string: bbbaaccbbbaaccbbb");
                    System.out.println("Target occurence: -5");
                    System.out.print("Result: ");
                    System.out.println(q1.searchString("bbb", "bbbaaccbbbaaccbbb", 0, 0, -5));

                    System.out.println("\nNOT FOUND in big string");
                    System.out.println("-------------------------------------");
                    System.out.println("Small string: zzz");
                    System.out.println("Big string: bbbaaccbbbaaccbbb");
                    System.out.println("Target occurence: 1");
                    System.out.print("Result: ");
                    System.out.println(q1.searchString("zzz", "bbbaaccbbbaaccbbb", 0, 0, 1));

                } else if (choice == 2) {
                    Q2 q2 = new Q2();
                    int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
                    System.out.println("Lower bound < Fist index value ");
                    System.out.println("-------------------------------------");
                    System.out.println("Sorted integer array: [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ]");
                    System.out.println("Lower bound: 5");
                    System.out.println("Upper bound: 65");
                    System.out.print("Result: ");
                    System.out.println(q2.wrapperFindItems(arr, 5, 65));

                    System.out.println("\nUpper bound > Last index value ");
                    System.out.println("-------------------------------------");
                    System.out.println("Sorted integer array: [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ]");
                    System.out.println("Lower bound: 70");
                    System.out.println("Upper bound: 200");
                    System.out.print("Result: ");
                    System.out.println(q2.wrapperFindItems(arr, 70, 200));

                    System.out.println("\nLower bound == Fist index value && Upper bound == Last index value");
                    System.out.println("-------------------------------------");
                    System.out.println("Sorted integer array: [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ]");
                    System.out.println("Lower bound: 10");
                    System.out.println("Upper bound: 100");
                    System.out.print("Result: ");
                    System.out.println(q2.wrapperFindItems(arr, 10, 100));

                    System.out.println("\nLower bound == any value && Upper bound == any value");
                    System.out.println("-------------------------------------");
                    System.out.println("Sorted integer array: [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ]");
                    System.out.println("Lower bound: 20");
                    System.out.println("Upper bound: 80");
                    System.out.print("Result: ");
                    System.out.println(q2.wrapperFindItems(arr, 20, 80));

                    System.out.println(
                            "\nNOT FOUND any value - Lower bound < Fist index value && Upper bound < First index value");
                    System.out.println("-------------------------------------");
                    System.out.println("Sorted integer array: [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ]");
                    System.out.println("Lower bound: 0");
                    System.out.println("Upper bound: 5");
                    System.out.print("Result: ");
                    System.out.println(q2.wrapperFindItems(arr, 0, 5));

                    System.out.println("\nFOUND ONLY one value in given range");
                    System.out.println("-------------------------------------");
                    System.out.println("Sorted integer array: [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ]");
                    System.out.println("Lower bound: 45");
                    System.out.println("Upper bound: 55");
                    System.out.print("Result: ");
                    System.out.println(q2.wrapperFindItems(arr, 45, 55));

                } else if (choice == 3) {
                    Q3 q3 = new Q3();
                    int[] items = { -8, 1, 4, 0, 1, 3, 2, 2, -2, 7, 0, 1, 5 };
                    System.out.println("All test conditions are provided in these examples:");
                    System.out.println("- Subarray in first part");
                    System.out.println("- Subarray in middle part");
                    System.out.println("- Subarray in last part");
                    System.out.println("- Subarray with 0");
                    System.out.println("- Subarray without 0");
                    System.out.println("- Subarray with negative values");
                    System.out.println("-------------------------------------");
                    System.out.println("Unsorted integer array: [ -8, 1, 4, 0, 1, 3, 2, 2, -2, 7, 0, 1, 5 ]");
                    System.out.println("Target sum: 5");
                    System.out.println("Subarray/s: ");
                    System.out.println("------------------");
                    q3.targetSum(items, 0, 0, 0, 5);

                    System.out.println("\nUnsorted integer array: [ 0, 3, 0, -1, 4, 0 ]");
                    System.out.println("Target sum: -8");
                    System.out.println("Subarray/s: ");
                    System.out.println("------------------");
                    q3.targetSum(items, 0, 0, 0, -8);

                    int[] items2 = { 0, 3, 0, -1, 4, 0 };
                    System.out.println("\nUnsorted integer array: [ 0, 3, 0, -1, 4, 0 ]");
                    System.out.println("Target sum: 3");
                    System.out.println("Subarray/s: ");
                    System.out.println("------------------");
                    q3.targetSum(items2, 0, 0, 0, 3);

                } else if (choice == 5) {
                    Q5 q5 = new Q5();
                    char[] blocks = new char[7];
                    for (int i = 0; i < blocks.length; i++) {
                        blocks[i] = ' ';
                    }
                    System.out.println("---------------------");
                    System.out.println("\nBLOCK NUM: 3");
                    System.out.println("LENGTH: 7");
                    System.out.println("---------------------");
                    q5.fillArray(blocks, 0, 0, 0, 1, 3);

                    char[] blocks2 = new char[14];
                    for (int i = 0; i < blocks2.length; i++) {
                        blocks2[i] = ' ';
                    }
                    System.out.println("\nBLOCK NUM: 5");
                    System.out.println("LENGTH: 14");
                    q5.fillArray(blocks2, 0, 0, 0, 1, 5);

                    char[] blocks3 = new char[29];
                    for (int i = 0; i < blocks3.length; i++) {
                        blocks3[i] = ' ';
                    }
                    System.out.println("\nBLOCK NUM: 29");
                    System.out.println("LENGTH: 29");
                    q5.fillArray(blocks3, 0, 0, 0, 1, 29);
        
                    for (int i = 0; i < blocks3.length; i++) {
                        blocks3[i] = ' ';
                    }
                    System.out.println("\nBLOCK NUM: 50");
                    System.out.println("LENGTH: 29");
                    q5.fillArray(blocks3, 0, 0, 0, 1, 50);

                } else if (choice == 6) {
                    
                    System.out.println("-------------------");
                    System.out.println("MATRIX SIZE: 1 X 1");
                    System.out.println("-------------------");
                    Q6 snake = new Q6(1);
                    snake.solveGame();

                    System.out.println("\n-----------------");
                    System.out.println("MATRIX SIZE: 2 X 2");
                    System.out.println("-------------------");
                    Q6 snake2 = new Q6(2);
                    snake2.solveGame();

                    System.out.println("\n-----------------");
                    System.out.println("MATRIX SIZE: 3 X 3");
                    System.out.println("-------------------");
                    Q6 snake3 = new Q6(3);
                    snake3.solveGame();
                    
                    System.out.println("\n-----------------");
                    System.out.println("MATRIX SIZE: 4 X 4");
                    System.out.println("-------------------");
                    Q6 snake4 = new Q6(4);
                    snake4.solveGame();

                } else if (choice == 0) {
                    scan.close();
                    return;
                } else
                    System.out.println("--Invalid choice!\n");
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

}
