package digitaldesign;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


class UnboxerTest {
    private static final String INVALID = "INVALID";
    private Unboxer unboxer = new Unboxer();

    @Test
    void whenThereAreNoAnyParentheses() {
        String in = "Some Text";
        String result = unboxer.unbox(in);
        assertThat(result, is(in));
    }

    @Test
    void whenThereIsOnePairParenthesesButNoNumber() {
        String in = "tes[t]";
        String result = unboxer.unbox(in);
        assertThat(result, is(INVALID));
    }

    @Test
    void whenOddNumberOfParentheses() {
        String in = "te2[st]]";
        String result = unboxer.unbox(in);
        assertThat(result, is(INVALID));
    }

    @Test
    void whenStringIsValidAndOnePairOfParentheses() {
        String in = "xx2[y]xx";
        String result = unboxer.unbox(in);
        String expected = "xxyyxx";
        assertThat(result, is(expected));
    }

    @Test
    void whenTwoPairOfParenthesesGoesSequentially() {
        String in = "2[Wi]2[Fi]";
        String result = unboxer.unbox(in);
        String expected = "WiWiFiFi";
        assertThat(result, is(expected));
    }

    @Test
    void whenTwoPairOfParenthesesGoesSequentiallyAndSomeLettersAmongThem() {
        String in = "AAA3[O]AAA3[O]AAA";
        String result = unboxer.unbox(in);
        String expected = "AAAOOOAAAOOOAAA";
        assertThat(result, is(expected));
    }

    @Test
    void whenFourPairOfParenthesesGoesSequentially() {
        String in = "s1[S]s2[S]s3[S]s4[S]s";
        String result = unboxer.unbox(in);
        String expected = "sSsSSsSSSsSSSSs";
        assertThat(result, is(expected));
    }

    @Test
    void whenOnePairParenthesesHasInnerParentheses() {
        String in = "aa2[b3[c]]";
        String result = unboxer.unbox(in);
        String expected = "aabcccbccc";
        assertThat(result, is(expected));
    }

    @Test
    void whenOnePairParenthesesHasFourInnerAndAnotherOneHasTreeInnerParentheses() {
        String in = "2[a2[b2[c2[d]]]]3[E3[F3[G]]]";
        String result = unboxer.unbox(in);
        String expected = "abcddcddbcddcddabcddcddbcddcddEFGGGFGGGFGGGEFGGGFGGGFGGGEFGGGFGGGFGGG";
        assertThat(result, is(expected));
    }
}