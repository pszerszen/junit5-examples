package com.pgs.junit5.examples.vintage;


import com.pgs.junit5.examples.Generator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class E05ExceptionsTestingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {
        new Generator().generate(null,0);
    }

    @Test
    public void shouldThrowExceptionWithMessage() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("length must not be lower than 3");

        new Generator().generate("AAAE",0);
    }
}
