package yandex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceTest {
    @Test
    public void test() {
        Conference conference = new Conference();
        conference.readDataFromFile();
    }

}