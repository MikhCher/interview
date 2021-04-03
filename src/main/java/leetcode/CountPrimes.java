package leetcode;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimeArr = new boolean[n];
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimeArr[i - 1]) {
                counter++;
            }
            for (int j = 1; i * j < n; j++) {
                notPrimeArr[i * j - 1] = true;
            }
        }
        return counter;
    }
}
