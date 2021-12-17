public class SearchDriver {
    // var stores len of array
    public static final int N = 1_000_000_000;
    public static void main(String[] args) {

        int[] bigArr = new int[N];
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = i;
        }
    }
}