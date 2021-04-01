package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class FindDuplicatesTest {
    @Test
    public void whenHereAreTwoDuplicates() {
        FindDuplicates findDuplicates = new FindDuplicates();
        int[] arrayInput = new int[] {4,3,2,7,8,2,3,1};
        List<Integer> result = findDuplicates.findDuplicates(arrayInput);
        List<Integer> expected = Arrays.asList(2, 3);
        assertThat(result, is(expected));
    }
}