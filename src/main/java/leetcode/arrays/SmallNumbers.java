package leetcode.arrays;

import java.util.Arrays;

public class SmallNumbers {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] array = Arrays.copyOf(nums, nums.length);
        Arrays.sort(array);
        String values = Arrays.toString(array);
        values = values.substring(1, values.length() - 1).replace(", ", "");
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = values.indexOf(String.valueOf(nums[i]));
        }
        return nums;
    }
}
