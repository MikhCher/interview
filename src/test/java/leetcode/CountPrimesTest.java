package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

class CountPrimesTest {
    @Test
    public void whenSeekingPrimalOfZeroAndOne() {
        int input = 0;
        int result = new CountPrimes().countPrimes(input);
        int expected = 0;
        assertThat(result, is(expected));
        input = 1;
        result = new CountPrimes().countPrimes(input);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSeekingPrimalOf120() {
        int input = 120;
        int result = new CountPrimes().countPrimes(input);
        int expected = 30;
        assertThat(result, is(expected));
    }
}