package com.pgs.junit5.examples;

import com.pgs.junit5.examples.extensions.MockitoExtension;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class E07Mockito {

    @Mock
    private Pair<String, String> pair;

    @BeforeEach
    void setUp() {
        when(pair.getKey()).thenReturn("key");
        when(pair.getValue()).thenReturn("val");
    }

    @Test
    void test() {
        assertEquals("key", pair.getKey());
        assertEquals("val", pair.getValue());
    }
}
