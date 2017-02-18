package com.pgs.junit5.examples;

import com.pgs.junit5.examples.extensions.callback.Benchmark;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Benchmark
public class GeneratorTest {
    @DisplayName("when input is correct")
    @Nested
    class WhenInputIsCorrect {

        @Test
        @DisplayName("then generator returns combinations")
        void shouldGenerateCombinations() {
            String actual = "aaa";

            assertAll(
                    () -> assertThat(actual).isEqualTo("aaa"),
                    () -> assertThat(actual).isEqualTo("aaa")
            );
        }

        @Test
        @DisplayName("then generator returns combinations - expected to fail")
        void shouldGenerateCombinationsFail() {
            String actual = "aaa";

            assertAll("result",
                    () -> assertThat(actual).isEqualTo("aab"),
                    () -> assertThat(actual).isEqualTo("aaa"));
        }

    }
}
