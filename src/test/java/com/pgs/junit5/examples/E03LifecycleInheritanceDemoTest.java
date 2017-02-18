package com.pgs.junit5.examples;

import com.pgs.junit5.examples.extensions.tags.Special;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Log4j2
public class E03LifecycleInheritanceDemoTest {

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

    @Nested
    class NestedTest {

        @BeforeEach
        public void beforeEach() {
            log.debug("\tnested beforeEach");
        }

        @AfterEach
        public void afterEach() {
            log.debug("\tnested afterEach");
        }

        @Special
        @Test
        void test() {
            log.debug("\tnested testing");
        }
    }

    @Nested
    class AnotherNestedTest {

        @BeforeEach
        public void beforeEach() {
            log.debug("\tanother nested beforeEach");
        }

        @AfterEach
        public void afterEach() {
            log.debug("\tanother nested afterEach");
        }

        @Test
        void test() {
            log.debug("\tanother nested testing");
        }
    }
}
