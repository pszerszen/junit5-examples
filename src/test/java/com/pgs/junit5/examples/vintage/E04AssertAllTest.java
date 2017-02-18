package com.pgs.junit5.examples.vintage;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class E04AssertAllTest {

    @Test
    public void shouldReturnCollectionOfSizeWithFixedFirstElement() {
        List<String> actual = getActual();

        assertEquals("Size must be 3", 3, actual.size());
        assertEquals("AZZ element must be first", "AZZ", actual.get(0));
    }

    private List<String> getActual() {
        return ImmutableList.of("AAA", "anything");
    }


}
