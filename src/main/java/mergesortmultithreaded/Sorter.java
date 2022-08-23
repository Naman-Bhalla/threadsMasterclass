package mergesortmultithreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Generics/ Templates
public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;

    public Sorter(List<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() <= 1) { // 7, 2, 9, 1, 5, 6
            return arrayToSort;
        }

        // [7, 2, 9, 1, 5, 6]
        int mid = arrayToSort.size()/ 2; // 3

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        // 7, 2, 9
        for (int i = 0; i < mid; ++i) {
            leftArray.add(arrayToSort.get(i));
        }

        // 1, 5, 6
        for (int i = mid; i < arrayToSort.size(); ++i) {
            rightArray.add(arrayToSort.get(i));
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<List<Integer>> leftSortedArrayFuture = executor.submit(new Sorter(leftArray));
        Future<List<Integer>> rightSortedArrayFuture = executor.submit(new Sorter(rightArray));

        List<Integer> leftSortedArray = leftSortedArrayFuture.get();
        List<Integer> rightSortedArray = rightSortedArrayFuture.get();

        List<Integer> mergedArray = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if (leftSortedArray.get(i) < rightSortedArray.get(j)) {
                mergedArray.add(leftSortedArray.get(i));
                i++;
            } else {
                mergedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while (i < leftSortedArray.size()) {
            mergedArray.add(leftSortedArray.get(i));
            i++;
        }

        while (j < rightSortedArray.size()) {
            mergedArray.add(rightSortedArray.get(j));
            j++;
        }

        return mergedArray;
    }
}
