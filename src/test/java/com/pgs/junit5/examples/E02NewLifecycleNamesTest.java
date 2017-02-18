package com.pgs.junit5.examples;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class E02NewLifecycleNamesTest {
    @BeforeAll
    public static void beforeAll() {
        log.debug("beforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        log.debug("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        log.debug("afterEach");
    }

    @AfterAll
    public static void afterAll() {
        log.debug("afterAll");
    }

    @Test
    void test() {
        log.debug("testing");
    }
}
