package com.slam.alg.amazon;
import java.util.*;

public class FindAllCombination {
    public static int numberOfOptions(List<Integer> a, List<Integer> b, List<Integer> c, List<Integer> d, int limit) {
        List<Integer> e = new ArrayList<>();
        List<Integer> f = new ArrayList<>();
        int result = 0;
        
        for(int i = 0; i < a.size(); i ++) {
            for(int j = 0; j < b.size(); j ++) {
                if(a.get(i) + b.get(j) < limit) {
                   e.add(a.get(i) + b.get(j));
                }
                
               
            }
        }
        
        for(int i = 0; i < c.size(); i ++) {
            for(int j = 0; j < d.size(); j ++) {
               if(c.get(i) + d.get(j) < limit) {
                   f.add(c.get(i) + d.get(j));
               }
            }
        }
        
        Collections.sort(e);
        Collections.sort(f);

        int left = 0;
        int right = f.size() -1;

        while(left < e.size() && right >= 0) {
            while(left < e.size() && right > 0 && (e.get(left) + f.get(right) <= limit)) {
                result ++;
                left++;
            }
            right --;
            left = 0;

        }

        
        return result;
    }
}
