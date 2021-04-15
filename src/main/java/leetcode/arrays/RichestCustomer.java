package leetcode.arrays;

public class RichestCustomer {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int value : accounts[i]) {
                sum += value;
            }
            if (sum > max) max = sum;
        }
        return max;
    }
}
