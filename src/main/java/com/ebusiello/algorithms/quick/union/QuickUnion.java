package com.ebusiello.algorithms.quick.union;

/**
 * http://algs4.cs.princeton.edu/15uf/
 *
 * Instead of changing all the element in the array, build a tree like structure
 * so that only the root must be changed.
 */
public class QuickUnion {

    private Integer[] nodes;
    private Integer nodesSize;

    public QuickUnion(int size) {
        nodesSize = size;
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
            // change only the root of the tree in the array.
            nodes[findRoot(i1)] = findRoot(i2);
            return true;
        }
        else return false;
    }

    private Integer findRoot(int i) {
        Integer ind = nodes[i];
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