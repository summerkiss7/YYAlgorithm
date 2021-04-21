package com.slam.alg.sort;

public class QuickSelect {

    public int kthLargestElement(int n, int[] nums) {
        if(nums == null || nums.length == 0) {
            return  -1;
        }

        return quickSelect(0, nums.length-1, n, nums);
    }

    int quickSelect(int start, int end, int k, int[] nums) {
        int left = start;
        int right = end;
        int pivot = nums[(left + right)/2];
        while(left < right) {
            while(left < right && nums[left] <= pivot) {
                left++;
            }
            while(left < right && nums[right] >= pivot) {
                right--;
            }

            if(left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        if(start + k -1 <= right) {
            quickSelect(start, right, k, nums);
        }

        if(start + k -1 >= left) {
            quickSelect(left, end, k - (left -start), nums);
        }

        return nums[right + 1];
    }
}
