package com.pgs.junit5.examples;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.stream.Stream;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@Log4j2
public class E06Parametrized {

    @TestFactory
    @ExtendWith(FibonacciParameterResolver.class)
    Stream<DynamicTest> test(Stream<Pair<Integer, Integer>> dataSet) {
        return dataSet.map(pair -> test(pair.getKey(), pair.getValue()));
    }

    private DynamicTest test(final int input, final int expected) {
        return dynamicTest(format("input={%d}, expected={%d}", input, expected),
                () -> assertEquals(expected, Fibonacci.compute(input)));
    }

    @Test
    @DisplayName("Test not needing parameters.")
    public void test2() {
    }

    private static class FibonacciParameterResolver implements ParameterResolver {

        @Override
        public boolean supports(final ParameterContext parameterContext, final ExtensionContext extensionContext) throws ParameterResolutionException {
            return parameterContext.getParameter().getType().equals(Stream.class);
        }

        @Override
        public Object resolve(final ParameterContext parameterContext, final ExtensionContext extensionContext) throws ParameterResolutionException {
            return Stream.of(
                    params(0, 0),
                    params(1, 1),
                    params(2, 1),
                    params(3, 2),
                    params(4, 3),
                    params(5, 5),
                    params(6, 8));
        }

        private Pair<Integer, Integer> params(int input, int expected) {
            return ImmutablePair.of(input, expected);
        }
    }
}
