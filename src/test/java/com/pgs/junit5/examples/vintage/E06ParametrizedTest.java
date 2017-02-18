package com.pgs.junit5.examples.vintage;

import com.pgs.junit5.examples.Fibonacci;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class E06ParametrizedTest {

    @Parameters(name = "input={0}, expected={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }

    private final int fInput;
    private final int fExpected;

    @Test
    public void test() {
        Assert.assertEquals(fExpected, Fibonacci.compute(fInput));
    }

}


