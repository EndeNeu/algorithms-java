package com.ebusiello.algorithms.quick.union;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickUnionSpec {

    @Test
    public void testMain() {
        QuickUnion qu = new QuickUnion(10);

        assertEquals("a new matrix should be disconnected", qu.isConnected(2, 9), false);
        assertEquals("a new matrix should be disconnected", qu.isConnected(2, 10), false);
        assertEquals("a new matrix should be disconnected", qu.isConnected(1, 2), false);
        assertEquals("a new matrix should be disconnected", qu.isConnected(5, 4), false);
        assertEquals("Wrong index should return false", qu.isConnected(-90, 111), false);
        assertEquals("Wrong index should return false", qu.isConnected(12, 111), false);
        assertEquals("Wrong index should return false", qu.isConnected(-12, 5), false);

        qu.union(4, 3);
        qu.union(3, 8);
        qu.union(9, 4);
        qu.union(6, 5);
        qu.union(2, 1);
        assertEquals("8 and 9 should be connected", qu.isConnected(8, 9), true);
        assertEquals("5 and 4 should be connected", qu.isConnected(5, 4), false);
        qu.union(5, 0);
        qu.union(7, 2);
        qu.union(6, 1);
        assertEquals("6 and 1 should be connected", qu.isConnected(6, 1), true);
        assertEquals("2 and 1 should be connected", qu.isConnected(2, 1), true);
        assertEquals("5 and 0 should be connected", qu.isConnected(5, 0), true);
        assertEquals("0 and 1 should be connected", qu.isConnected(0, 1), true);
        assertEquals("4 and 3 should be connected", qu.isConnected(4, 3), true);
        assertEquals("8 and 9 should be connected", qu.isConnected(9, 8), true);
        assertEquals("9 and 3 should be connected", qu.isConnected(9, 3), true);
        assertEquals("9 and 4 should be connected", qu.isConnected(4, 9), true);
    }
}