import java.util.ArrayList;

/**
 * class SearchDriver
 * tests BinSearch and LinSearch with
 * arrays of length 1 billion
 * searching for random indexes within that array
 * 100x per search type
 * stores program run length for each in respective long array
 * prints average run length at end
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
        
        long programStart = System.currentTimeMillis();

        long arrstart = System.currentTimeMillis();
        // create and fillin array
        int[] bigArr = new int[LEN];
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = i;
        }
        long arrend = System.currentTimeMillis();
        System.out.println("Time to create and fill array: " + (arrend-arrstart) + " milliseconds");


        ArrayList<Long> binSearchTimes = new ArrayList<Long>();
        ArrayList<Long> linSearchTimes = new ArrayList<Long>();

        for (int i = 0; i < REPEAT; i++) {
            int index = (int) (Math.random() * LEN);

            long start = System.currentTimeMillis();
            IntBinSearch.binSearch(bigArr, index);
            long end = System.currentTimeMillis();

            binSearchTimes.add(end-start);

            start = System.currentTimeMillis();
            IntLinSearch.linSearch(bigArr, index);
            end = System.currentTimeMillis();

            linSearchTimes.add(end-start);
        }

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