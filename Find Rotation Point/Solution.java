import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
        
        int begin = 0;
        int end = words.length - 1;
        while (begin < end) {
            int mid = (begin+end) / 2;
            if (words[begin].compareTo(words[mid]) <= 0) {
                begin = mid+1;
            } else {
                end = mid;
            }
        }
        return words[end].compareTo(words[0]) < 0 ? end : 0;
    }

    // tests

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[] {"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
            "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
            new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
            "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
    }


    @Test
    public void noRotationTest() {
        final int actual = findRotationPoint(
            new String[] {"asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage",
                "ptolemaic", "retrograde", "supplant", "undulate", "xenoepist"});
        final int expected = 0;
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