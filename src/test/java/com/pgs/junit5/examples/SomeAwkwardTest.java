package com.pgs.junit5.examples;

import com.pgs.junit5.examples.callback.Benchmark;
import com.pgs.junit5.examples.condition.DisabledOn;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@Benchmark
@DisabledOn({DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY})
public class SomeAwkwardTest {

    @Test
    void assertThatResultIsNotEmpty() {
        assertThat("s").isEmpty();
        log.warn("executed");
    }
}
