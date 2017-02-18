package com.pgs.junit5.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class E051ExceptionsTestingTest {

    @Test
    public void shouldThrowException() {
        Throwable throwable = assertThrows(IllegalArgumentException.class,
                () -> new Generator().generate(null, 0));

        assertEquals("parameter must not be null", throwable.getMessage());
    }

    @Test
    public void shouldThrowExceptionWithMessage() {
        new Generator().generate("AAAE", 0);
    }
}
