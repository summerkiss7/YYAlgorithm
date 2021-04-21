package com.slam.alg.bfs;
import java.util.*;
import java.util.stream.Collectors;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int ansbfs = bfs(M);
        return ansbfs;
    }

    int bfs(int[][] M) {
        int n = M.length;
        int asn = 0;
        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                asn ++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);

                while(!queue.isEmpty()) {
                    int now = queue.poll();
                    for( int j = 0; j < n; j ++) {
                        if(!visited[j] && M[now][j] == 1) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
                
            }
        }
        return asn;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int relationshipsLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> relationships = new ArrayList<>();
        for (int i = 0; i < relationshipsLength; i++) {
            relationships.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int res = friendCircles(relationships);
        System.out.println(res);
    }
    public static int friendCircles(List<List<Integer>> relationships) {
        return bfs(relationships);
   }

    static int bfs(List<List<Integer>> relationships) {
        int n = relationships.size();
        int asn = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++ ) {
            if(!visited[i]) {
                visited[i] = true;
                asn++;
                
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                
                while(!q.isEmpty()) {
                    int now = q.poll();
                     for(int j = 0; j < n; j ++) {
                         if(!visited[j] && relationships.get(now).get(j) == 1) {
                             visited[j] = true;
                             q.offer(j);
                         }   
                     }
                }
            }
        }
        
        
        
        return asn;
    }
}
