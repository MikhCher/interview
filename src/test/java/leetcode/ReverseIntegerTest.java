package leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

class ReverseIntegerTest {
    @Test
    public void whenReversingPositiveNumber() {
        int number = 123;
        int result = new ReverseInteger().reverse(number);
        int expected = 321;
        assertThat(result, is(expected));
    }

    @Test
    public void whenReversingNumberWithTailingZero() {
        int number = 120;
        int result = new ReverseInteger().reverse(number);
        int expected = 21;
        assertThat(result, is(expected));
    }

    @Test
    public void whenReversingNegativeNumber() {
        int number = -123;
        int result = new ReverseInteger().reverse(number);
        int expected = -321;
        assertThat(result, is(expected));
    }

    @Test
    public void whenReversingZero() {
        int number = 0;
        int result = new ReverseInteger().reverse(number);
        int expected = 0;
        assertThat(result, is(expected));
    }

}