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
            nodes[i] = i;
            sizes[i] = 1;
        }
    }

    /**
     * To avoid making the tree too deep, always connect the smaller tree to the root of the bigger tree.
     */
    public void union(int i1, int i2) {
        if(isIndexValid(i1) && isIndexValid(i2)) {
            int root1 = findRoot(i1);
            int root2 = findRoot(i2);
            // if the root is the same they are connected.
            if (root1 == root2) return;
            // else if the size of the second tree is bigger, link the root of the first
            // tree to the root of the second and update the depth of the second tree
            else if (sizes[root1] < sizes[root2]) {
                nodes[root1] = root2;
                sizes[root2] += sizes[root1];
            }
            // else the other way around.
            else {
                nodes[root2] = root1;
                sizes[root1] += sizes[root2];
            }
        }
    }

    private int findRoot(int i) {
        int ind = nodes[i];
        // if the index is equal to the element at that index it means it is the root of itself
        // means we find the root.
        if(ind == i) return i;
        else return findRoot(ind);
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < nodesSize;
    }

    /**
     * Two connected nodes have the same root.
     */
    public boolean isConnected(int i1, int i2) {
        return isIndexValid(i1) && isIndexValid(i2) && findRoot(i1) == findRoot(i2);
    }

}