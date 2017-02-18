package com.pgs.junit5.examples;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class E06DynamicTest {

    @TestFactory
    Stream<DynamicTest> fibonacciTestFactory() {
        return Stream.of(
                params(0, 0),
                params(1, 1),
                params(2, 1),
                params(3, 2),
                params(4, 3),
                params(5, 5),
                params(6, 8))
                .map(this::callTest);
    }

    private DynamicTest callTest(Pair<Integer, Integer> params) {
        return test(params.getKey(), params.getValue());
    }

    private DynamicTest test(final int input, final int expected) {
        return dynamicTest(format("input={%d}, expected={%d}", input, expected),
                () -> assertEquals(expected, Fibonacci.compute(input)));
    }

    private Pair<Integer, Integer> params(int input, int expected) {
        return ImmutablePair.of(input, expected);
    }

    @Test
    @DisplayName("Test not needing parameters.")
    public void test2() {
    }

}
