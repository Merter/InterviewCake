import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int[] getProductsOfAllIntsExceptAtIndex(final int[] nums) {
        // make an array of the products
        if (nums==null || nums.length <= 1) {
            throw new IllegalArgumentException();
        }
        final int[] productsOfAllIntsExceptAtIndex = new int[nums.length];
        int productFromLeft = 1;
        productsOfAllIntsExceptAtIndex[0] = productFromLeft;
        for (int i=1; i<nums.length; i++) {
            productFromLeft *= nums[i-1];
            productsOfAllIntsExceptAtIndex[i] = productFromLeft;
        }
        int productFromRight = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productFromRight;
            productFromRight *= nums[i];
        }
        return productsOfAllIntsExceptAtIndex;
    }

    // tests

    @Test
    public void smallArrayTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {1, 2, 3});
        final int[] expected = new int[] {6, 3, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {8, 2, 4, 3, 1, 5});
        final int[] expected = new int[] {120, 480, 240, 320, 960, 192};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasOneZeroTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {6, 2, 0, 3});
        final int[] expected = new int[] {0, 0, 36, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoZerosTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {4, 0, 9, 1, 0});
        final int[] expected = new int[] {0, 0, 0, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneNegativeNumberTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-3, 8, 4});
        final int[] expected = new int[] {32, -12, -24};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void allNegativeNumbersTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-7, -1, -4, -2});
        final int[] expected = new int[] {-8, -56, -14, -28};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        getProductsOfAllIntsExceptAtIndex(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        getProductsOfAllIntsExceptAtIndex(new int[] {1});
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
