package com.pgs.junit5.examples.vintage;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class E07Mockito {

    @Mock
    private Pair<String, String> pair;

    @Before
    public void setUp() {
        when(pair.getKey()).thenReturn("key");
        when(pair.getValue()).thenReturn("val");
    }

    @Test
    public void test() {
        assertEquals("key", pair.getKey());
        assertEquals("val", pair.getValue());
    }
}
