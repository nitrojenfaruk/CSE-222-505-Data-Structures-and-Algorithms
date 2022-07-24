
public class Main {
    public static <T> void main(String[] args) throws Exception {

        long startTime, endTime; 
        double totalTime;

        /*------------------------Q1-P1--------------------------------- */
        HashTableChain<Integer, Integer> chain = new HashTableChain<>();
        System.out.println("\nisEmpty : " + chain.isEmpty());
        System.out.println("CAPACITY: " + HashTableChain.getCapacity());
        System.out.println("LOAD_THRESHOLD: " + HashTableChain.getLoad() + "\n");
        chain.put(3, 1);
        System.out.println("Insert 3:");
        System.out.println("----------\n" + chain + "\n");
        chain.put(12, 2);
        System.out.println("Insert 12:");
        System.out.println("----------\n" + chain + "\n");
        chain.put(13, 3);
        System.out.println("Insert 13:");
        System.out.println("----------\n" + chain + "\n");
        chain.put(25, 4);
        System.out.println("Insert 25:");
        System.out.println("----------\n" + chain + "\n");
        chain.put(23, 5);
        System.out.println("Insert 23:");
        System.out.println("----------\n" + chain + "\n");
        chain.put(51, 6);
        System.out.println("Insert 51:");
        System.out.println("----------\n" + chain + "\n");
        chain.remove(25);
        System.out.println("Delete 25:");
        System.out.println("----------\n" + chain);
        System.out.println("isEmpty : " + chain.isEmpty() + "\n");
        System.out.println("----------\n");

        System.out.println("\n*****************************************");
        System.out.println("            Q1-P2 HYBRID HASHING         ");
        System.out.println("*****************************************");
        // 3, 12, 13, 25, 23, 51, and delete 25
        HybridHashing<Integer, Integer> hybrid = new HybridHashing<>();
        System.out.println("\n" + "isEmpty : " + hybrid.isEmpty() + "\n");
        hybrid.put(3, 1);
        System.out.println("Insert 3:");
        System.out.println("----------\n" + hybrid + "\n");
        hybrid.put(12, 2);
        System.out.println("Insert 12:");
        System.out.println("----------\n" + hybrid + "\n");
        hybrid.put(13, 3);
        System.out.println("Insert 13:");
        System.out.println("----------\n" + hybrid + "\n");
        hybrid.put(25, 4);
        System.out.println("Insert 25:");
        System.out.println("----------\n" + hybrid + "\n");
        hybrid.put(23, 5);
        System.out.println("Insert 23:");
        System.out.println("----------\n" + hybrid + "\n");
        hybrid.put(51, 6);
        System.out.println("Insert 51:");
        System.out.println("----------\n" + hybrid + "\n");
        hybrid.remove(25);
        System.out.println("Delete 25:");
        System.out.println("----------\n" + hybrid);
        System.out.println("isEmpty : " + hybrid.isEmpty() + "\n");

        
        double total = 0;
        final int N = 100;
        final int SMALL_SIZE = 100;
        final int MEDIUM_SIZE = 1000;
        final int LARGE_SIZE = 10000;

        HashTableChain<Integer, Integer> chainTest = new HashTableChain<>();
        HybridHashing<Integer, Integer> hybridTest = new HybridHashing<>();

        System.out.println("\n--------------");
        System.out.println("100 element");
        System.out.println("--------------");

        System.out.println("Is HashTableChain table empty: " + chainTest.isEmpty());
        System.out.println("Is HybridHashing table empty: " + hybridTest.isEmpty() + "\n");

        for (int i = 0; i < N; i++) {
            startTime = System.nanoTime();
            chainTest.remove((int) Math.random());
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);

        }
        System.out.println("Removing NOT exist elements in HashTableChain: " + total / SMALL_SIZE  );

        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.remove((int) Math.random());
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);

        }
        System.out.println("Removing NOT exist elements in HybridHashing: " + total / SMALL_SIZE   + "\n");


        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting NOT exist elements in HashTableChain: " + total / SMALL_SIZE  );

        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting NOT exist elements in HybridHashing: " + total / SMALL_SIZE   + "\n");


        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.put(i, i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Adding operation in HashTableChain:: " + total / SMALL_SIZE  );

        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.put(i, i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Adding operation in HybridHashing: " + total / SMALL_SIZE   + "\n");

        
        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting elements in HashTableChain: " + total / SMALL_SIZE  );

        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting elements in HybridHashing: " + total / SMALL_SIZE   + "\n");
        
        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing elements in HashTableChain: " + total / SMALL_SIZE  );

        total = 0;
        for (int i = 0; i < SMALL_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing elements in HybridHashing: " + total / SMALL_SIZE + "\n");
        System.out.println("\n--------------");
        System.out.println("1000 element");
        System.out.println("--------------");



        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing NOT exist elements in HashTableChain: " + total / MEDIUM_SIZE  );

        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing NOT exist elements in HybridHashing: " + total / MEDIUM_SIZE   + "\n");

        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting NOT exist elements in HashTableChain: " + total / MEDIUM_SIZE  );

        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting NOT exist elements in HybridHashing: " + total / MEDIUM_SIZE   + "\n");


        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.put(i, i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Adding operation in HashTableChain:: " + total / MEDIUM_SIZE  );

        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.put(i, i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Adding operation in HybridHashing: " + total / MEDIUM_SIZE   + "\n");

        
        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting elements in HashTableChain: " + total / MEDIUM_SIZE  );

        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting elements in HybridHashing: " + total / MEDIUM_SIZE   + "\n");
        
        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing elements in HashTableChain: " + total / MEDIUM_SIZE  );

        total = 0;
        for (int i = 0; i < MEDIUM_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing elements in HybridHashing: " + total / MEDIUM_SIZE + "\n");




        System.out.println("\n--------------");
        System.out.println("10000 element");
        System.out.println("--------------");


        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing NOT exist elements in HashTableChain: " + total / LARGE_SIZE );

        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing NOT exist elements in HybridHashing: " + total / LARGE_SIZE  + "\n");

        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting NOT exist elements in HashTableChain: " + total / LARGE_SIZE );

        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting NOT exist elements in HybridHashing: " + total / LARGE_SIZE + "\n");


        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.put(i, i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Adding operation in HashTableChain:: " + total / LARGE_SIZE );

        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.put(i, i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Adding operation in HybridHashing: " + total / LARGE_SIZE  + "\n");

        
        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting elements in HashTableChain: " + total / LARGE_SIZE );

        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.get(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Getting elements in HybridHashing: " + total / LARGE_SIZE  + "\n");
        
        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            chainTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing elements in HashTableChain: " + total / LARGE_SIZE );

        total = 0;
        for (int i = 0; i < LARGE_SIZE; i++) {
            startTime = System.nanoTime();
            hybridTest.remove(i);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            total += (totalTime / 1000000);
        }
        System.out.println("Removing elements in HybridHashing: " + total / LARGE_SIZE  + "\n");

        
        double totalMerge = 0;
        double totalQuick = 0;
        double totalNew = 0;
        double averageMerge = 0.0;
        double averageQuick = 0.0;
        double averageNew = 0.0;
        Integer[] smallArr = new Integer[100];
        Integer[] mediumArr = new Integer[1000];
        Integer[] largeArr = new Integer[10000];

		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < SMALL_SIZE; j++) {
				smallArr[j] = (int) Math.random();
			}

			startTime = System.nanoTime();
            MergeSort.sort(smallArr);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalMerge += (totalTime / 1000000);

			startTime = System.nanoTime();
            QuickSort.sort(smallArr);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalQuick += (totalTime / 1000000);

			startTime = System.nanoTime();
            NewSort.new_sort(smallArr, 0, smallArr.length - 1);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalNew += (totalTime / 1000000);

		}

		averageMerge = totalMerge / 1000;
		averageQuick = totalQuick / 1000;
		averageNew = totalNew / 1000;

		System.out.println("SMALL SIZE: 100");
        System.out.println("----------------");
		System.out.println("Average running time of Merge Sort: "+ averageMerge);
		System.out.println("Average running time of Quick Sort: "+ averageQuick);
		System.out.println("Average running time of New Sort: "+ averageNew);



		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < MEDIUM_SIZE; j++) {
				mediumArr[j] = (int) Math.random();
			}

			startTime = System.nanoTime();
            MergeSort.sort(mediumArr);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalMerge += (totalTime / 1000000);

			startTime = System.nanoTime();
            QuickSort.sort(mediumArr);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalQuick += (totalTime / 1000000);

			startTime = System.nanoTime();
            NewSort.new_sort(mediumArr, 0, mediumArr.length - 1);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalNew += (totalTime / 1000000);

		}

		averageMerge = totalMerge / 1000;
		averageQuick = totalQuick / 1000;
		averageNew = totalNew / 1000;

		System.out.println("\nMEDIUM SIZE: 1000");
        System.out.println("----------------");
		System.out.println("Average running time of Merge Sort: "+ averageMerge);
		System.out.println("Average running time of Quick Sort: "+ averageQuick);
		System.out.println("Average running time of New Sort: "+ averageNew);


		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < LARGE_SIZE; j++) {
				largeArr[j] = (int) Math.random();
			}

			startTime = System.nanoTime();
            MergeSort.sort(largeArr);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalMerge += (totalTime / 1000000);

			startTime = System.nanoTime();
            QuickSort.sort(largeArr);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalQuick += (totalTime / 1000000);

			startTime = System.nanoTime();
            NewSort.new_sort(largeArr, 0, largeArr.length - 1);
            endTime = System.nanoTime();
            totalTime = (double) endTime - startTime;
            totalNew += (totalTime / 1000000);

		}

		averageMerge = totalMerge / 1000;
		averageQuick = totalQuick / 1000;
		averageNew = totalNew / 1000;

		System.out.println("\nLARGE SIZE: 10000");
        System.out.println("----------------");
		System.out.println("Average running time of Merge Sort: "+ averageMerge);
		System.out.println("Average running time of Quick Sort: "+ averageQuick);
		System.out.println("Average running time of New Sort: "+ averageNew);


    }

}
