import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class Solution {

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
        final boolean evenLength = theString.length() % 2 == 0;
        final Map<Character, Integer> char2count = new HashMap<>();
        int evenCountChar = 0;
        int oddCountChar =0;
        for (int i=0; i<theString.length(); i++) {
            final Character currChar = theString.charAt(i);
            Integer count = char2count.get(currChar);
            if (count == null) {
                count = 1;
                oddCountChar++;
            } else {
                count++;
                if (count % 2 == 0) {
                    evenCountChar++;
                    oddCountChar--;
                } else {
                    evenCountChar--;
                    oddCountChar++;
                }
            }
            char2count.put(currChar, count);
        }
        if (oddCountChar > 1) {
            return false;
        }
        if (evenLength && oddCountChar == 1) {
            return false;
        }
        if (!evenLength && oddCountChar == 0) {
            return false;
        }
        return true;
    }

    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
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