import java.util.ArrayList;
import java.util.List;

import com.slam.alg.bfs.TreeNode;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        
         List<String> paths = new ArrayList<>();

         if(root == null) {
             return paths;
         }

         List<TreeNode> path = new ArrayList<>();
         path.add(root);
         dfs(root, path, paths);
         return paths;
    }

    void dfs(TreeNode node, List<TreeNode> path, List<String> paths) {
           if(node.left == null && node.right == null) {
               paths.add(getPath(path));
           }

           if(node.left != null) {
               path.add(node.left);
               dfs(node.left, path, paths);
               path.remove(node.left);
           }

           if(node.right != null) {
            path.add(node.right);
            dfs(node.right, path, paths);
            path.remove(node.right);
        }
    }

    String getPath(List<TreeNode> path) {
        String p = "";
        for(int i = 0; i < path.size(); i++) {
                if(i != path.size() - 1) {
                     p = p + String.valueOf(path.get(i).val).concat("->") ;
                }else {
                    p = p + String.valueOf(path.get(i).val).concat("");
                }
        }
        return p;
    }
    
}