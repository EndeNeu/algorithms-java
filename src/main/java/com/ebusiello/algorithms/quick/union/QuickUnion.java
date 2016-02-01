package com.ebusiello.algorithms.quick.union;

import java.util.ArrayList;

/**
 * http://algs4.cs.princeton.edu/15uf/
 *
 * Instead of changing all the element in the array, build a tree like structure
 * so that only the root must be changed.
 */
public class QuickUnion {

    private ArrayList<Integer> nodes = new ArrayList<Integer>();
    private int nodesSize = nodes.size();

    public QuickUnion(int size) {
        for (int i = 0; i < size; i++) {
            insert(i);
        }
    }

    public void insert(int i) {
        nodes.add(i);
        nodesSize = nodesSize + 1;
    }

    public boolean union(int i1, int i2) {
        if(isConnected(i1, i2)) return true;
        else if(isIndexValid(i1) && isIndexValid(i2)) {
            // change only the root of the tree in the array.
            nodes.set(findRoot(i1), findRoot(i2));
            return true;
        }
        else return false;
    }

    private Integer findRoot(int i) {
        Integer ind = nodes.get(i);
        if(ind.equals(i)) return i;
        else return findRoot(ind);
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < nodesSize;
    }

    public boolean isConnected(int i1, int i2) {
        return isIndexValid(i1) && isIndexValid(i2) && findRoot(i1).equals(findRoot(i2));
    }

}