package leetcode;

import java.util.Arrays;

public class Finder {
    int[] find(int[] array, int expSum) {
        Arrays.sort(array);
        for (int i : array) {
            if (Arrays.binarySearch(array, expSum - i) > 0)
                return new int[]{i, array[Arrays.binarySearch(array, expSum - i)]};
        }
        return new int[0];
    }
}

