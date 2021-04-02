package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

class OutermostParenthesesTest {
    @Test
    public void removeOutermost() {
        String input = "(()())(())";
        String expected = "()()()";
        String result = new OutermostParentheses().removeOuterParentheses(input);
        assertThat(result, is(expected));
    }
}