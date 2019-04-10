package com.codecool.quicksort;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;

public class QuickSort {

    /**
     * Sorts the given List in place
     * @param toSort the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> toSort) {
            if(toSort == null) {
                throw new IllegalArgumentException();
            }

            Collections.shuffle(toSort);
            sortingSides(toSort, 0, toSort.size() - 1);
    }

    private void sortingSides(List<Integer> toSort, int lowestIndex, int highestIndex) {
            if(highestIndex <=lowestIndex) {
                return;
            }
            //get the position of sorted pivot, which divides the sides
            int divider = partition(toSort, lowestIndex, highestIndex);
            //sort the left side
            sortingSides(toSort, lowestIndex, divider-1);
            //sort the right side
            sortingSides(toSort, divider+1, highestIndex);
    }

    private int partition(List<Integer> toSort, int lowestIndex, int highestIndex) {
        int i = lowestIndex;
        int j = highestIndex;

        int pivot = toSort.get(lowestIndex);

        while(true) {
            //starting from the left, while item on index 'i' smaller than the pivot, step to the right
            while(toSort.get(i) <= pivot) {
                i++;
                //if the steps reach the end of the list, break
                if(i == highestIndex) {
                    break;
                }
            //starting from the right, while item on index 'i' larger than the pivot, step to the left
            } while(toSort.get(j) >= pivot) {
                j--;
                //if the steps reach the start of the list, break
                if(j == lowestIndex) {
                    break;
                }
            }

            //if the steps from left and right crossed, break
            if(i >= j) {
                break;
            }

            //if item from the left is bigger than the pivot AND the item from the right is smaller than the pivot,
            //i and j not crossed, swap them in the list
            swap(toSort, i, j);
        }

        //if i and j crossed, swap the pivot with the biggest smaller element than the pivot, the right side of the left block

        swap(toSort, lowestIndex, j);
        return j;
    }
}
