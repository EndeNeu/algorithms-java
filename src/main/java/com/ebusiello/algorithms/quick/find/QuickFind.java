package com.ebusiello.algorithms.quick.find;

public class QuickFind {

    private Integer[] nodes;
    private Integer nodesSize = null;

    public QuickFind(int size) {
        nodesSize = size;
        nodes = new Integer[size];
        for (int i = 0; i < size; i++) {
            insert(i);
        }
    }

    public void insert(int i) {
        nodes[i] = i;
    }

    public boolean union(int i1, int i2) {
        if(isConnected(i1, i2)) return true;
        else if(isIndexValid(i1) && isIndexValid(i2)) {
            // store the values at the indexes we want to change
            Integer i1Value = nodes[i1];
            Integer i2Value = nodes[i2];
            for (int i = 0; i < nodesSize; i++) {
                // if the value at position i is the same as the one at position i1
                // we need to change it with the value at index i2.
                if(nodes[i].equals(i1Value)) nodes[i] = i2Value;
            }
            return true;
        }
        else return false;
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < nodesSize;
    }

    public boolean isConnected(int i1, int i2) {
        return isIndexValid(i1) && isIndexValid(i2) && nodes[i1].equals(nodes[i2]);
    }

}