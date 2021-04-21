package com.slam.alg.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemInContianers {

    public static List<Integer> numberOfItems(String s, List<List<Integer>> ranges) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }
        int curSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>(); 

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|') {
                prefixSums.put(i, curSum);
            }else{
                curSum ++;
            }
        }

        int[] leftBounds = new int[s.length()];
        int last = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|') {
                last = i;
            }
            leftBounds[i] = last;
        }

        int[] rightBounds = new int[s.length()];
        last = -1;
        for(int i = s.length() -1; i >= 0; i--) {
            if(s.charAt(i) == '|') {
                last = i;
            }
            rightBounds[i] = last;
        }

        for(int i = 0; i < ranges.size(); i++) {
            int start = rightBounds[ranges.get(i).get(0)];
            int end = leftBounds[ranges.get(i).get(1)];
            if(start != -1 && end != -1 && start < end) {
                result.add(prefixSums.get(end) - prefixSums.get(start));
            }else {
                result.add(0);
            }
        }
        return result;
    }
}