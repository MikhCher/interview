package leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

class TwoSumTest {
    @Test
    public void test() {
        TwoSum seeker = new TwoSum();

        int[] input = new int[] {3, 2, 4};
        int target = 6;
        int[] result = seeker.twoSum(input, target);
        int[] expected = new int[] {1, 2};
        assertThat(result, is(expected));

        input = new int[] {3, 3};
        result = seeker.twoSum(input, target);
        expected = new int[] {0, 1};
        assertThat(result, is(expected));
    }
}