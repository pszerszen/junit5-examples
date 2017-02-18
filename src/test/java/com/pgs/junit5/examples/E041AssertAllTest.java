package com.pgs.junit5.examples;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class E041AssertAllTest {

    @Test
    public void shouldReturnCollectionOfSizeWithFixedFirstElement() {
        List<String> actual = getActual();

        assertAll("collection",
                () -> assertEquals(3, actual.size(), "Size must be 3"),
                () -> assertEquals("AZZ", actual.get(0), "AAA element must be first")
        );
    }

    private List<String> getActual() {
        return ImmutableList.of("AAA", "anything");
    }

}
