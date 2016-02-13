package com.ebusiello.algorithms.quick.find;

public class QuickFind {

    private int[] nodes;
    private int nodesSize;

    public QuickFind(int size) {
        nodesSize = size;
        nodes = new int[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = i;
        }
    }

    /**
     * Change all the values equal to the one at position i to the value at position j
     */
    public boolean union(int i1, int i2) {
        if(isConnected(i1, i2)) return true;
        else if(isIndexValid(i1) && isIndexValid(i2)) {
            // store the values at the indexes we want to change
            int i1Value = nodes[i1];
            int i2Value = nodes[i2];
            for (int i = 0; i < nodesSize; i++) {
                // if the value at position i is the same as the one at position i1
                // we need to change it with the value at index i2.
                if(nodes[i] == i1Value) nodes[i] = i2Value;
            }
            return true;
        }
        else return false;
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < nodesSize;
    }

    /**
     * If two nodes are connected the will have the same value in the array
     */
    public boolean isConnected(int i1, int i2) {
        return isIndexValid(i1) && isIndexValid(i2) && nodes[i1] == nodes[i2];
    }

}