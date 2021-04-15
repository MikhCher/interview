package leetcode.arrays;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int index = 0;
        for (int value : nums) {
            sum += value;
            nums[index++] = sum;
        }
        return nums;
    }
}
