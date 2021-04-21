package com.slam.alg.towpoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumDataStructure {
    List<Integer> nums;
    Map<Integer, Integer> map;

    public TwoSumDataStructure() {
        nums = new ArrayList();
        map = new HashMap();
    }

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        if(!map.containsKey(number)) {
            nums.add(number);
            map.put(number, 1);
        }else {
            map.put(number, map.get(number) + 1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for(int num : nums) {
            if( value - num == num && map.getOrDefault(num, 0) > 1) {
                return true;
            }else if(value - num != num && map.containsKey(value - num)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumDataStructure t = new TwoSumDataStructure();
        t.add(2);
        t.add(3);
        t.add(3);
        t.find(6);

    }
}
