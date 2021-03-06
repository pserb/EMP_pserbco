// PSerb & Co. Paul Serbanescu, Andrew Piatetsky, Joseph Othman
// APCS pd7
// L03 - Get Empirical
// 2021-12-21
// time spent: 3.2 hrs

import java.util.ArrayList;

/**
 * class SearchDriver
 * tests BinSearch and LinSearch with
 * arrays of length 1 billion
 * searching for random indexes within that array
 * 1000x per search type
 * stores search run length for each in respective long array
 * prints time to create and fill array
 * prints average search run length
 * prints total program run length
 */

public class SearchDriver {
    // var stores len of array (the independent variable)
    public static final int LEN = 10_000_000;
    // number of random indexes searched (higher values results in higher accuracy of tests; 1,000 is a good middle ground)
    public static final int REPEAT = 1_000;

    public static long sum(ArrayList<Long> a) {
        long s = 0;
        for (int i = 0; i < a.size(); i++) {
            s += a.get(i);
        }
        return s;
    }

    public static void main(String[] args) {

        System.out.println("=======================================\n\nTEST:");
        System.out.println("\nArray Length:" + LEN);
        System.out.println("\nNumber of times repeated:" + REPEAT);
        System.out.println("\n===========================================\n");


        
        // for timing the time it took to run main method
        long programStart = System.currentTimeMillis();

        // for timing the initilization of array of LEN
        long arrstart = System.currentTimeMillis();

        // create and fillin array
        Comparable[] bigArr = new Comparable[LEN];
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = (Comparable) i;
        }

        // for timing how long it took to fill and create bigArr
        long arrend = System.currentTimeMillis();
        System.out.println("Time to create and fill array: " + (arrend-arrstart) + " milliseconds");

        // array lists for storing how long each run took
        ArrayList<Long> binSearchTimes = new ArrayList<Long>();
        ArrayList<Long> linSearchTimes = new ArrayList<Long>();

        // looping REPEAT times to get a large selection of random numbers generated 
        for (int i = 0; i < REPEAT; i++) {
            // setting index to search for (uncomment only one at a time)
                int index = LEN-1; // WORST CASE
                // int index = (int) (Math.random() * LEN); // RANDOM INDEX

            // timing how long it takes binary search to find index
            long start = System.currentTimeMillis();
            BinSearch.binSearch(bigArr, index);
            long end = System.currentTimeMillis();

            // adding how long binsearch took to binSearchTimes (to get average at the end)
            binSearchTimes.add(end-start);

            // timing how long it takes linear search to find index
            start = System.currentTimeMillis();
            LinSearch.linSearch(bigArr, index);
            end = System.currentTimeMillis();

            // adding how long lin search took to linSearchTimes (to get average at the end)
            linSearchTimes.add(end-start);
        }

        // summing using method to find averages
        long binSum = sum(binSearchTimes);
        long linSum = sum(linSearchTimes);

        System.out.println("\nBinSearch total: " + binSum + " milliseconds");
        System.out.println("BinSearch average: " + binSum/(REPEAT*1.0) + " milliseconds");
        System.out.println("\nLinSearch total: " + linSum + " milliseconds");
        System.out.println("LinSearch average: " + linSum/(REPEAT*1.0) + " milliseconds");

        long programEnd = System.currentTimeMillis();

        System.out.println("\nTotal program length: " + (programEnd-programStart) + " milliseconds, " + ((programEnd-programStart)/1000.0) + " seconds");

        System.out.println("\n=================================\n");
    }
}
