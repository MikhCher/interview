package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

class FizzBuzzTest {
    @Test
    public void whenHereIsTheOnlyValue() {
        int input = 1;
        List<String> result = new FizzBuzz().fizzBuzz(input);
        List<String> expected = Arrays.asList("1");
        assertThat(result, is(expected));
    }

    @Test
    public void whenHereAreFifteenValues() {
        int input = 15;
        List<String> result = new FizzBuzz().fizzBuzz(input);
        List<String> expected = Arrays.asList( "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "13", "14", "FizzBuzz");
        assertThat(result, is(expected));
    }
}