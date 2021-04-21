package com.slam.alg.sort;

/*
输入: A=[1,2,3,4], B=[2,4,5,6]
输出: [1,2,2,3,4,4,5,6]
样例解释: 返回合并后的数组。
 */
public class MergeSortedArray {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return B;
        }

        if (B == null || B.length == 0) {
            return A;
        }
        int[] C = new int[A.length + B.length];

        int a = 0, b = 0, c = 0;

        while (a < A.length && b < B.length) {
            if (A[a] <= B[b]) {
                C[c] = A[a];
                a++;
            } else {
                C[c] = B[b];
                b++;
            }
            c++;
        }
        while(a < A.length) {
            C[c] = A[a];
            a++;
            c++;
        }

        while(b < B.length) {
            C[c] = B[b];
            b++;
            c++;
        }
        return  C;
    }
   //归并排序使用了分治的思想，无论是什么样的数据，所花费的时间都是O(nlogn)的
}
