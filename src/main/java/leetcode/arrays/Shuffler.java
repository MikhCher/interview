package leetcode.arrays;

public class Shuffler {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[nums.length];
        for (int i = 0, j = 0; i < n; i++, j += 2) {
            shuffled[j] = nums[i];
            shuffled[j + 1] = nums[i + n];
        }
        return shuffled;
    }
}
