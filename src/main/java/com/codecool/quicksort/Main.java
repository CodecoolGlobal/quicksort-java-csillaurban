package com.codecool.quicksort;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Use the tests to check your code!
        QuickSort quicksort = new QuickSort();

        Integer numbers[] = new Integer[] {32, 76, 2, 8, 7, 19, 56, 10};
        List<Integer> toSort = Arrays.asList(numbers);

        quicksort.sort(toSort);
    }

}
