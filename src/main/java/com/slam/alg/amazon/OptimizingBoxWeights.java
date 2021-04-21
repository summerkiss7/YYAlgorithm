package com.slam.alg.amazon;

import java.util.*;

public class OptimizingBoxWeights {

    public static List<Integer> optimizingBoxWeights(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.size() == 0) {
            return result;
        }

        int target = arr.stream().reduce(0, Integer::sum) / 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {return b - a; }); 
        pq.addAll(arr);

        int curSum = 0;
        while(curSum <= target) {
            int weight = pq.poll();
            curSum += weight;
            result.add(weight);
        }
        Collections.reverse(result);

        return result;

    }
}