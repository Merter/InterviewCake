import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class Solution {

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        // determine if two movies add up to the flight length
        Set<Integer> uniqueMovieLengths = new HashSet<>();
        for (final int movieLength : movieLengths) {
            final int lengthOfOtherMovie = flightLength-movieLength;
            if (uniqueMovieLengths.contains(lengthOfOtherMovie)) {
                return true;
            }
            uniqueMovieLengths.add(movieLength);
        }
        return false;
    }
    
    
    public static boolean canTwoMoviesFillFlightSorted(int[] sortedMovieLengths, int flightLength) {

        // determine if two movies add up to the flight length
        for (int currentMovieIndex=0; currentMovieIndex<sortedMovieLengths.length; currentMovieIndex++) {
            final int currentMovieLength = sortedMovieLengths[currentMovieIndex];
            final int lengthOfOtherMovie = flightLength-currentMovieLength;
            final int indexOfOtherMovie = Arrays.binarySearch(sortedMovieLengths, lengthOfOtherMovie);
            if (indexOfOtherMovie>=0 && indexOfOtherMovie!=currentMovieIndex) {
                return true;
            }
        }
        return false;
    }

    // tests

    @Test
    public void shortFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {2, 4}, 1);
        assertFalse(result);
    }

    @Test
    public void longFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {2, 4}, 6);
        assertTrue(result);
    }

    @Test
    public void onlyOneMovieHalfFlightLenghtTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {3, 8}, 6);
        assertFalse(result);
    }

    @Test
    public void twoMoviesHalfFlightLengthTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {3, 8, 3}, 6);
        assertTrue(result);
    }

    @Test
    public void lotsOfPossiblePairsTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {1, 2, 3, 4, 5, 6}, 7);
        assertTrue(result);
    }

    @Test
    public void notUsingFirstMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {4, 3, 2}, 5);
        assertTrue(result);
    }

    @Test
    public void oneMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {6}, 6);
        assertFalse(result);
    }

    @Test
    public void noMoviesTest() {
        final boolean result = canTwoMoviesFillFlight(new int[] {}, 6);
        assertFalse(result);
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