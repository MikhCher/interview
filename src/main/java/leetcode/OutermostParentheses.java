package leetcode;

public class OutermostParentheses {
    public String removeOuterParentheses(String S) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (counter != 0) sb.append(c);
                counter++;
            } else if (c == ')') {
                counter--;
                if (counter != 0) sb.append(c);
            }
        }
        return sb.toString();
    }
}
