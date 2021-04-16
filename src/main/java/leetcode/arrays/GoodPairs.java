package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class GoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : nums) {
            if (map.containsKey(value)) {
                counter += map.get(value);
                map.put(value, map.get(value) + 1);
            } else map.put(value, 1);
        }
        return counter;
    }
}
