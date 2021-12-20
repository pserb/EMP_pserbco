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
    // var stores len of array
    public static final int LEN = 1_000_000_000;
    // number of random indexes searched
    public static final int REPEAT = 1_000;

    public static long sum(ArrayList<Long> a) {
        long s = 0;
        for (int i = 0; i < a.size(); i++) {
            s += a.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        
        // for timing the time it took to run main method
        long programStart = System.currentTimeMillis();

        // for timing the initilization of array of LEN
        long arrstart = System.currentTimeMillis();

        // create and fillin array
        int[] bigArr = new int[LEN];
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = i;
        }

        // for timing how long it took to fill and create bigArr
        long arrend = System.currentTimeMillis();
        System.out.println("Time to create and fill array: " + (arrend-arrstart) + " milliseconds");

        // array lists for storing how long each run took
        ArrayList<Long> binSearchTimes = new ArrayList<Long>();
        ArrayList<Long> linSearchTimes = new ArrayList<Long>();

        // looping REPEAT times to get a large selection of random numbers generated 
        for (int i = 0; i < REPEAT; i++) {
            // getting random index to search for
            int index = (int) (Math.random() * LEN);

            // timing how long it takes binary search to find index
            long start = System.currentTimeMillis();
            IntBinSearch.binSearch(bigArr, index);
            long end = System.currentTimeMillis();

            // adding how long binsearch took to binSearchTimes (to get average at the end)
            binSearchTimes.add(end-start);

            // timing how long it takes linear search to find index
            start = System.currentTimeMillis();
            IntLinSearch.linSearch(bigArr, index);
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
    }
}