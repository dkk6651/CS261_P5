import java.util.*;
import java.io.*;

public class SubsetSum{
    public static int [][] M;

    public static void main (String [] args) throws FileNotFoundException {
        // read input file
	Scanner sc = new Scanner(new File(args[0]));
        int W = Integer.parseInt(args[1]);
	int n = Integer.parseInt(sc.nextLine());
	int [] itemWts = new int[n+1];
	itemWts[0] = 0;
	for (int i = 1; i <= n; i++)
	    itemWts[i] = Integer.parseInt(sc.nextLine());

	long start = System.currentTimeMillis();
	int maxWeight = subsetSumMem(itemWts, W );
	long stop = System.currentTimeMillis();
	System.out.println("Memoized: Max Weight for " + n + " items = " +
			   maxWeight);
	System.out.println("Time = " + (stop-start));
        System.out.println("\nSolution");
        showSolution(itemWts, W, itemWts.length-1);
	
	start = System.currentTimeMillis();
	maxWeight = subsetSumR(itemWts, W, n);
	stop = System.currentTimeMillis();
	System.out.println("\nRecursive: Max Weight for " + n + " items = " +
			   maxWeight);
	System.out.println("Time = " + (stop-start));
    }

    /**
     *
     * @ param int [] itemWts - an array of the weights of items, itemWts[i]
     *                          is the weight of item i
     *         int W - the capacity allowed
     * @ return int - maximized sum of weights from itemWts <= W
     *                    that is compatible with jobs[j]
     */
    public static int subsetSumMem(int [] itemWts, int W) {
        M = new int [itemWts.length][W+1];
	// FINISH ME
	return 0;

    }

    /**
     *
     * @ param int [] itemWts - an array of the weights of items, itemWts[i]
     *                          is the weight of item i
     *         int w - the current capacity allowed
     *         int i - index of item under consideration
     * @ return int - maximized sum of weights from itemWts <= W
     *                    that is compatible with jobs[j]
     */
    public static int subsetSumR(int [] itemWts, int w, int i) {

	// FINISH ME
	return 0;
    }

    /**
     *
     * @ param int [] itemWts - an array of the weights of items, itemWts[i]
     *                          is the weight of item i
     *         int w - the current capacity allowed
     *         int i - index of item under consideration
     * @ return int - maximized sum of weights from itemWts <= W
     *                    that is compatible with jobs[j]
     */
    public static void showSolution(int [] itemWts, int w, int i) {
	// FINISH ME
    }
    
}
