package leetcode.arrays;

import java.util.Arrays;
import java.util.List;

public class KidsAndCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int value : candies)
            if (value > max) max = value;

        Boolean[] boolArray = new Boolean[candies.length];
        for (int i = 0; i < candies.length; i++) {
            boolArray[i] = candies[i] + extraCandies >= max;
        }
        return Arrays.asList(boolArray);
    }
}
