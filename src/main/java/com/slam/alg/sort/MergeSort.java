package com.slam.alg.sort;

public class MergeSort {
    public void sortIntegers(int[] A) {
        if(A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);


    }

    void mergeSort(int[] A, int start, int end, int[] temp) {
        if(start >= end) {
            return;
        }
        mergeSort(A, start, (start + end)/2, temp);
        mergeSort(A, (start + end)/2 + 1, end, temp);
        merge(A, start, end,temp);
    }

    void merge(int[] A, int start, int end, int temp[]) {
        int middle = (start + end)/2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = leftIndex;
        while(leftIndex <= middle && rightIndex<= end) {
            if(A[leftIndex] <= A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            }else {
                temp[index++] = A[rightIndex++];
            }
        }
        while(leftIndex <= middle ) {
            temp[index++] = A[leftIndex++];
        }

        while(rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }

        for(int i = 0; i < A.length ; i ++) {
            A[i] = temp[i];
        }
    }
}

