package leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        String strVal = Integer.toString(x);
        if (x < 0) strVal = strVal.substring(1);
        try {
            int candidate = Integer.parseInt(new StringBuilder(strVal).reverse().toString());
            return x > 0 ? candidate : -candidate;
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
