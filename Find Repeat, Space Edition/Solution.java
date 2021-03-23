// import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int findRepeat(int[] theArray) {

        // find a number that appears more than once
        
        // by sorting
        // Arrays.sort(theArray);
        // for (int i=0; i<theArray.length; i++) {
        //     if (theArray[i] == theArray[i+1]) {
        //         return theArray[i];
        //     }
        // }
        
        // by brute force
        // for (int i=0; i<theArray.length-1; i++) {
        //     for (int j=i+1; j<theArray.length; j++) {
        //         if (theArray[i] == theArray[j]) {
        //             return theArray[i];
        //         }
        //     }
        // }
        
        int begin = 1;
        int end = theArray.length-1;
        while (begin < end) {
            int mid = (end+begin) / 2;
            int smallerHalfCount = 0;
            int greaterHalfCount = 0;
            for (final int num : theArray) {
                if (num <= mid) {
                    smallerHalfCount++;
                } else {
                    greaterHalfCount++;
                }
            }
            if (smallerHalfCount > mid) {
                end = mid;
            } else {
                begin = mid+1;
            }
        }
        return begin;
    }
    
    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}