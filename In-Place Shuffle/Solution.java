import java.util.Arrays;
import java.util.Random;

public class Solution {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] theArray) {
        // shuffle the input in place
        if (theArray.length <= 1)
        {
            return;
        }
        for (int i=1; i<theArray.length; i++)
        {
            final int swapPos = getRandom(0, i);
            swap(theArray, i, swapPos);
        }
    }
    
    private static void swap(final int[] theArray, final int from, final int to) {
        final int temp = theArray[from];
        theArray[from] = theArray[to];
        theArray[to] = temp;
    }

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }
}