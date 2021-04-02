package leetcode;

import java.util.Arrays;

public class ReturnToOrigin {
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        Arrays.sort(chars);
        moves = String.valueOf(chars);
        return (moves.lastIndexOf("L") - moves.indexOf("L") == moves.lastIndexOf("R") - moves.indexOf("R")) &&
                (moves.lastIndexOf("D") - moves.indexOf("D") == moves.lastIndexOf("U") - moves.indexOf("U"));

    }
}
