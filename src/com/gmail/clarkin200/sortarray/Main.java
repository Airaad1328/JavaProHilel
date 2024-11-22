package com.gmail.clarkin200.sortarray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayUtils arrayUtils = new ArrayUtils();

        System.out.println("Enter array size");
        final int ARR_SIZE = scanner.nextInt();

        int[] createdArr = new int[ARR_SIZE];

        fillArr(createdArr);

        int[] sortedArr = arrayUtils.mergeSort(createdArr);

        System.out.println("Non sorted array");
        System.out.println(Arrays.toString(createdArr));

        System.out.println("Sorted array");
        System.out.println(Arrays.toString(sortedArr));

        System.out.println("Find element");
        int target = scanner.nextInt();

        int result = arrayUtils.binarySearch(sortedArr, target);
        System.out.println("Index element " + target + " = " + result);


    }

    public static void fillArr(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(31);
        }
    }

}
