package com.pgs.junit5.examples;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class E04AssertAllTest {

    @Test
    public void shouldReturnCollectionOfSizeWithFixedFirstElement() {
        List<String> actual = getActual();

        Assert.assertEquals("Size must be 3", 3, actual.size());
        Assert.assertEquals("AZZ element must be first", "AZZ", actual.get(0));
    }

    private List<String> getActual() {
        return ImmutableList.of("AAA", "anything");
    }


}
