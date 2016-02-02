package com.ebusiello.algorithms.quick.weighted;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickUnionWeightedSpec {

    @Test
    public void testMain() {
        QuickUnionWeighted qu = new QuickUnionWeighted(10);

        qu.union(4, 3);
        qu.union(3, 8);
        qu.union(6, 5);
        qu.union(9, 4);
        qu.union(2, 1);
        qu.union(5, 0);
        qu.union(7, 2);
        qu.union(6, 1);

        assertEquals("6 and 2 shoud be connected", qu.isConnected(2, 6), true);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(1, 7), true);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(6, 4), false);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(6, 8), false);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(6, 9), false);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(6, 3), false);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(2, 3), false);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(1, 3), false);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(5, 6), true);

        qu.union(7, 3);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(6, 4), true);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(6, 8), true);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(6, 9), true);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(6, 3), true);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(2, 3), true);
        assertEquals("6 and 2 shoud be connected", qu.isConnected(1, 3), true);
    }
}