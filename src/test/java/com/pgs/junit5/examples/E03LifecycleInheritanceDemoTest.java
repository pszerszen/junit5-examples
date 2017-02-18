package com.pgs.junit5.examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class E03LifecycleInheritanceDemoTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    void test() {
        System.out.println("testing");
    }

    @Nested
    class NestedTest {

        @BeforeEach
        public void beforeEach() {
            System.out.println("\tnested beforeEach");
        }

        @AfterEach
        public void afterEach() {
            System.out.println("\tnested afterEach");
        }

        @Test
        void test() {
            System.out.println("\tnested testing");
        }
    }

    @Nested
    class AnotherNestedTest {

        @BeforeEach
        public void beforeEach() {
            System.out.println("\tanother nested beforeEach");
        }

        @AfterEach
        public void afterEach() {
            System.out.println("\tanother nested afterEach");
        }

        @Test
        void test() {
            System.out.println("\tanother nested testing");
        }
    }
}
