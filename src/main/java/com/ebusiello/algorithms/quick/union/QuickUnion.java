package com.ebusiello.algorithms.quick.union;

/**
 * http://algs4.cs.princeton.edu/15uf/
 * <p>
 * Instead of changing all the element in the array, build a tree like structure
 * so that only the root must be changed.
 */
public class QuickUnion {

    private int[] nodes;
    private int nodesSize;

    public QuickUnion(int size) {
        nodesSize = size;
        nodes = new int[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = i;
        }
    }

    /**
     * Two nodes are connected if they are in the same tree and they have the same root.
     */
    public void union(int i1, int i2) {
        if(isIndexValid(i1) && isIndexValid(i2)) {
            int root1 = findRoot(i1);
            int root2 = findRoot(i2);
            if(root1 == root2) return;
            else {
                nodes[root1] = root2;
            }
        }
    }

    private int findRoot(int i) {
        int ind = nodes[i];
        // if the index is equal to the element at that index it means it is the root of itself
        // means we find the root.
        if (ind == i) return i;
        else return findRoot(ind);
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < nodesSize;
    }

    public boolean isConnected(int i1, int i2) {
        return isIndexValid(i1) && isIndexValid(i2) && findRoot(i1) == findRoot(i2);
    }

}