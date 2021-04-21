package com.slam.alg.towpoints;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.length; i ++) {
            if(map.containsKey(target - numbers[i])) {
                return  new int[]{i, map.get(target - numbers[i])};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
