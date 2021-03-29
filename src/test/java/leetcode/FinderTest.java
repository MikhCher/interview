package leetcode;

import org.junit.jupiter.api.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

class FinderTest {
    @Test
    public void test() {
        Finder finder = new Finder();
        int[] arrayInput = new int[] {15, 4, 2, 9, 1, 3};
        int valueInput = 10;
        int[] result = finder. find(arrayInput, valueInput);
        int[] expected = new int[] {1, 9};
        assertThat(result, is(expected));
    }
}