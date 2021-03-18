package digitaldesign;

public class Unboxer {
    public String unbox(String rawString) {
        if (!isValid(rawString)) {
            return "INVALID";
        }
        StringBuilder sb = new StringBuilder(rawString);
        int startIndex = rawString.indexOf('[');
        int endIndex = rawString.indexOf(']');

        while (startIndex > 0) {
            String inner = rawString.substring(startIndex + 1, endIndex);
            while (inner.contains("[")) {
                endIndex = rawString.indexOf(']', endIndex + 1);
                inner = rawString.substring(startIndex + 1, endIndex);
                String deepest = findDeepest(inner);
                int deepestStart = inner.lastIndexOf('[');
                int deepestEnd = inner.indexOf(']');
                sb.delete(rawString.indexOf(inner.substring(deepestStart)) - String.valueOf(getNumberBeforeParentheses(inner)).length(),
                        deepestEnd + rawString.indexOf(inner) + 1);
                for (int i = 0; i < getNumberBeforeParentheses(inner); i++) {
                    sb.insert(deepestStart + rawString.indexOf(inner) - 1, deepest);
                }
                rawString = sb.toString();
                endIndex = rawString.indexOf(']');
                inner = rawString.substring(startIndex + 1, endIndex);
            }
            inner = rawString.substring(0, endIndex);
            sb.delete(startIndex - String.valueOf(getNumberBeforeParentheses(inner)).length(), endIndex + 1);
            for (int i = 0; i < getNumberBeforeParentheses(inner); i++) {
                sb.insert(startIndex - 1, inner.substring(inner.indexOf('[') + 1));
            }
            rawString = sb.toString();
            startIndex = rawString.indexOf('[');
            endIndex = rawString.indexOf(']');
        }

        return sb.toString().equals("") ? rawString : sb.toString() ;
    }

    private String findDeepest(String str) {
        int startIndex = str.lastIndexOf('[');
        int endIndex = str.indexOf(']');
        return str.substring(startIndex + 1, endIndex);
    }

    private int getNumberBeforeParentheses(String rawString) {
        int count = 0;
        int index = rawString.lastIndexOf('[');
        char ch = rawString.charAt(--index);
        while (Character.isDigit(ch)) {
            count++;
            if (index == 0) {
                index--;
                break;
            }
            ch = rawString.charAt(--index);
        }
        return Integer.parseInt(rawString.substring(index + 1, index + count + 1));
    }

    private boolean isValid(String rawString) {
        return isEvenParentheses(rawString)
                && rawString.matches("[a-zA-Z0-9\\s\\[\\]]*");
    }

    private boolean isEvenParentheses(String rawString) {
        int openCount = 0;
        int closeCount = 0;
        for (char c : rawString.toCharArray()) {
            if (c == '[') {
                openCount++;
                if (!isNumberBeforeParentheses(rawString, rawString.indexOf(c))) {
                    return false;
                }
            }
            if (c == ']') closeCount++;
        }
        return openCount == closeCount;
    }

    private boolean isNumberBeforeParentheses (String rawString, int index) {
        if (index == 0) return false;
        char symbol = rawString.charAt(index - 1);
        return symbol >= '0' && symbol <= '9';
    }
}
