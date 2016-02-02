package com.ebusiello.algorithms.quick.weighted;

/**
 * http://algs4.cs.princeton.edu/15uf/
 *
 * Instead of changing all the element in the array, build a tree like structure
 * so that only the root must be changed.
 */
public class QuickUnionWeighted {

    private int[] nodes;
    private int nodesSize;
    private int[] sizes;

    public QuickUnionWeighted(int size) {
        sizes = new int[size];
        nodes = new int[size];
        nodesSize = size;
        for (int i = 0; i < size; i++) {
            insert(i);
            sizes[i] = 1;
        }
    }

    public void insert(int i) {
        nodes[i] = i;
    }

    public boolean union(int i1, int i2) {
        if(isIndexValid(i1) && isIndexValid(i2)) {
            int root1 = findRoot(i1);
            int root2 = findRoot(i2);
            if (root1 == root2) return true;

            if (sizes[root1] < sizes[root2]) {
                nodes[root1] = root2;
                sizes[root2] += sizes[root1];
            }
            else {
                nodes[root2] = root1;
                sizes[root1] += sizes[root2];
            }
            return true;
        }
        else return false;
    }

    private int findRoot(int i) {
        int ind = nodes[i];
        if(ind == i) return i;
        else return findRoot(ind);
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < nodesSize;
    }

    public boolean isConnected(int i1, int i2) {
        return isIndexValid(i1) && isIndexValid(i2) && findRoot(i1) == findRoot(i2);
    }

}