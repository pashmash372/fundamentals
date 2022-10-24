package com.scaler.mergesort;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@AllArgsConstructor
public class Sorter implements Callable<List<Integer>> {

    private List<Integer> values = new ArrayList<>();
    private ExecutorService excecutorService;

    @Override
    public List<Integer> call() throws Exception {

//        Base case if the size of array 1 is return
        if (values.size() <= 1) return values;

//        split the array
        int mid = values.size() / 2;

        List<Integer> leftArray = values.subList(0, mid);
        List<Integer> rightArray = values.subList(mid, values.size());

        Sorter leftSorter = new Sorter(leftArray,excecutorService);
        Sorter rightSorter = new Sorter(rightArray,excecutorService);

        Future<List<Integer>> sortedLeft = excecutorService.submit(leftSorter);
        Future<List<Integer>> sortedRight = excecutorService.submit(rightSorter);

//        Merge the array

        return merge(sortedLeft, sortedRight);
    }

    private List<Integer> merge(Future<List<Integer>> sortedLeftFuture, Future<List<Integer>> sortedRightFuture) throws ExecutionException, InterruptedException {
        List<Integer> sortedArray = new ArrayList<>();
        int first = 0;
        int second = 0;

        List<Integer> sortedLeft = sortedLeftFuture.get();
        List<Integer> sortedRight = sortedRightFuture.get();

//        compare values from both the arrays
        while (first < sortedLeft.size() && second < sortedRight.size()) {
//            if left is smaller , add to sorted array
//            increment first
            if (sortedLeft.get(first) < sortedRight.get(second)) {
                sortedArray.add(sortedLeft.get(first));
                ++first;
            } else {
//                add the right one to the sorted array
//                increment second
                sortedArray.add(sortedRight.get(second));
                ++second;
            }
        }
        while (first < sortedLeft.size()) {
            sortedArray.add(sortedLeft.get(first));
            ++first;
        }
        while (second < sortedRight.size()) {
            sortedArray.add(sortedRight.get(second));
            ++second;
        }
        return sortedArray;
    }
}
