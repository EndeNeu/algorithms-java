package com.ebusiello.algorithms.search;

import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static int binarySearch(List<Integer> collection, int value) {
        Collections.sort(collection);
        return binarySearchImp(collection, value, 0);
    }

    private static int binarySearchImp(List<Integer> collection, int value, int indexSum) {
        // get the middle element of the list.
        int collectionLength = collection.size();
        int middleIndex = collectionLength / 2;
        int middle = collection.get(middleIndex);
        // if we found it return the index
        if (middle == value) return indexSum + middleIndex;
        else if (collectionLength == 1) return -1;
        //else if the value is smaller than the middle iterate the first part of the list and reset the index sum param.
        else if (middle > value) return binarySearchImp(collection.subList(0, middleIndex), value, indexSum);
        // else iterate the right part and use the index of the middle element as starting point.
        else return binarySearchImp(collection.subList(middleIndex, collectionLength), value, indexSum + middleIndex);
    }
}


