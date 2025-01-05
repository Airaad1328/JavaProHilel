package com.gmail.clarkin200.annotation;

import java.util.Arrays;

public class ArrayUtils {

    @Author(name = "Renat",surname = "Seitdzhelilov")
    @MethodInfo(name = "mergeSort",returnValue = "integer array",description = "Method to make merge sort")
    public int[] mergeSort(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("Array is empty");
        }
        if (arr.length < 2) {
            return arr;
        }

        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        int ARR_SIZE = sortedArray.length;
        int[] tempArray = new int[ARR_SIZE];


        for (int subSize = 1; subSize < ARR_SIZE; subSize *= 2) {
            for (int leftStart = 0; leftStart < ARR_SIZE; leftStart += 2 * subSize) {

                int mid = Math.min(leftStart + subSize, ARR_SIZE);
                int rightEnd = Math.min(leftStart + 2 * subSize, ARR_SIZE);

                merge(sortedArray, tempArray, leftStart, mid, rightEnd);
            }
        }

        return sortedArray;
    }

    private static void merge(int[] sortedArray, int[] tempArray, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;


        while (i < mid && j < right) {
            if (sortedArray[i] <= sortedArray[j]) {
                tempArray[k++] = sortedArray[i++];
            } else {
                tempArray[k++] = sortedArray[j++];
            }
        }

        while (i < mid) {
            tempArray[k++] = sortedArray[i++];
        }

        while (j < right) {
            tempArray[k++] = sortedArray[j++];
        }

        for (i = left; i < right; i++) {
            sortedArray[i] = tempArray[i];
        }
    }

    @Author(name = "Ilya",surname = "Lubinets")
    @MethodInfo(name = "binarySearch",returnValue = "integer array, integer",description = "Method to make binary search")
    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

}