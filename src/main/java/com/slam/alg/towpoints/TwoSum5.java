package com.slam.alg.towpoints;

import java.util.Arrays;

public class TwoSum5 {

    //[-1,-2,-3,-4,-5,-6,-100,-98,-111,-11]
    //-111
    public int twoSum5(int[] nums, int target) {
        if( nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int result = 0;
        int left = 0;
        int right = nums.length -1;
        while(left < right && left < nums.length -1) {
            while(left < right ) {
                if(nums[left] + nums[right] <= target) {
                    result ++;
                    System.out.print(nums[left] + "||");
                    System.out.println(nums[right]);
                }


                right --;
            }
            left ++;
            right = nums.length -1;

        }

        return result;
    }
    public static void main(String args[ ]) {
        TwoSum5 twoSum5 = new TwoSum5();
        twoSum5.twoSum5(new int[]{-1,-2,-3,-4,-5,-6,-100,-98,-111,-11}, -111);
    }
}
