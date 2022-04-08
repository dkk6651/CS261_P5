/**
 * File Name: SubsetSum.java
 * Author: Daniel Kee Kim
 * Description: Subset Sum algorithm implemented in both recursive and memoization methods.
 */

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
		if(W == 0) return 0;
		int n = itemWts.length-1;

		M = new int[n+1][W+1];
		for(int i = 0; i <= W; i++){
			M[0][i] = 0;
		}

        for(int i = 1; i <= n; i++){
			for(int w = 0; w <= W; w++){
				if(w < itemWts[i]){
					M[i][w] = M[i-1][w];
				}
				else{
					M[i][w] = Math.max(M[i-1][w], itemWts[i] + M[i-1][w - itemWts[i]]);
				}
			}
		}
        return M[n][W];
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
    	if(i == 0){
    		return 0;
		}
    	else if(itemWts[i] > w){
    		return subsetSumR(itemWts, w, i-1);
		}
    	else{
    		return Math.max(subsetSumR(itemWts, w, i-1), itemWts[i] + subsetSumR(itemWts, w - itemWts[i], i-1));
		}
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
		if(M[i][w] == 0){
			return;
		}
		else if(M[i][w] > M[i-1][w]){
			System.out.printf("item %d wt: %d\n", i, itemWts[i]);
			showSolution(itemWts, w - itemWts[i], i-1);
		}
		else{
			showSolution(itemWts, w, i-1);
		}
    }
    
}
