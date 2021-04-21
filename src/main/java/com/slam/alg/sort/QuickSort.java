package com.slam.alg.sort;

public class QuickSort {

    public void sort(int[] A) {
        if(A == null || A.length ==0) {
            return;
        }

        quickSort(A, 0, A.length);
    }

    void quickSort(int[] A, int start, int end) {
        if(start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = A[(start + end)/2];

        while(left <= right) {
            while(left <= right && A[left]< pivot) {
                left ++;
            }

            while(left < right && A[right] > pivot) {
                right --;
            }

            if(left < right) {
                int temp = A[left];
                A[left++] = A[right];
                A[right--] = temp;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
