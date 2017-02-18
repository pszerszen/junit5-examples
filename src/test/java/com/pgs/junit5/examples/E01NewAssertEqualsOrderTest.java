package com.pgs.junit5.examples;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class E01NewAssertEqualsOrderTest {

    @Test
    void shouldFind3Differences() {
        short expected = 3;
        short actual = 3;

        // Providing error message at the end
        assertEquals(expected, actual, getAssertionMessage());
    }

    @Test
    void shouldFind3DifferencesWithMessageSupplier() {
        short expected = 3;
        short actual = 3;

        // Providing supplier of the error message (lazy string construction)
        assertEquals(expected, actual, this::getAssertionMessage);
    }

    private String getAssertionMessage() {
        try {
            return new StringBuilder()
                    .append("must")
                    .append(" find")
                    .append(" 3 differences")
                    .toString();
        } finally {
            log.debug("assertion message has been computed. it was hard work.");
        }
    }
}
