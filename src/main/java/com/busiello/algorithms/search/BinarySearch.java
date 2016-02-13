package com.busiello.algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static int binarySearch(List<Integer> collection, int value) {
        Collections.sort(collection);
        System.out.println(collection);
        return binarySearchImp(collection, value, 0);
    }

    private static int binarySearchImp(List<Integer> collection, int value, int indexSum) {
        // get the middle element of the list.
        int middle = collection.get(collection.size() / 2);
        int middleIndex = collection.indexOf(middle);
        // if we found it return the index
        if (middle == value) return indexSum + middleIndex;
        //else if the value is smaller than the middle iterate the first part of the list and reset the
        else if (middle > value) return binarySearchImp(collection.subList(0, middleIndex), value, 0);
        else return binarySearchImp(collection.subList(middleIndex, collection.size()), value, indexSum + middleIndex);
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>(10);
        l.add(10);
        l.add(3);
        l.add(6);
        l.add(1);
        l.add(2);
        l.add(8);
        System.out.println(binarySearch(l, 10));
        System.out.println(binarySearch(l, 1));
        System.out.println(binarySearch(l, 6));
        System.out.println(binarySearch(l, 2));
        System.out.println(binarySearch(l, 3));
    }
}


