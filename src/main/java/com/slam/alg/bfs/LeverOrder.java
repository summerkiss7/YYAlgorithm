package com.slam.alg.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeverOrder {

    //DummyNode
    //1#23#4567#
    public List<List<Integer>> solution3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        List<Integer> level = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if( head == null) {
                if(level.size() == 0) {// the last #
                    continue;
                }
                result.add(level);
                level = new ArrayList<>();
                queue.offer(null);
                continue;
            }
            level.add(head.val);
            if(head.left != null) {
                queue.offer(head.left);
            }

            if(head.right != null) {
                queue.offer(head.right);
            }

        }

        return result;
    }


    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                TreeNode head = queue.poll();
                level.add(head.val);

                if(head.left != null) {
                    queue.offer(head.left);
                }

                if(head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return  result;
    }
}
