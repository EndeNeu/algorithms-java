package com.ebusiello.algorithms.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinarySearchSpec {
    @Test
    public void testMain() {
        List<Integer> coll = new ArrayList<Integer>(10);

        for (int i = 0; i < 10; i++) {
            coll.add(i, i);
        }

        assertEquals("a wrong index should return -1",BinarySearch.binarySearch(coll, 10), -1);

        for (int i = 0; i < 10; i++) {
            assertEquals("return the correct index",BinarySearch.binarySearch(coll, i), i);
        }

        Collections.reverse(coll);
        for (int i = 0; i < 10; i++) {
            assertEquals("return the correct index even if the list is unsorted",BinarySearch.binarySearch(coll, i), i);
        }
        BinarySearch.binarySearch(coll, 10);
    }

}
