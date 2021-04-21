package com.slam.alg.google;
import java.util.*;
import java.util.regex.Pattern;

public class MemeryFileSystem {
        class FileTreeNode {
            Boolean isfile;
            Map<String, FileTreeNode> fileTreeNodes = new HashMap<>();
            String content;

            public FileTreeNode(Boolean isFile) {
                this.isfile = isFile;
                if(isFile) {
                    this.content = "";
                }
            }
        } 


        private static String LINUX_PATH_SEPARATOR = "/";
        FileTreeNode root;

        public MemeryFileSystem(){
            root = new FileTreeNode(false);
        }

        public List<String> ls(String path) {
            List<String> fileNodes = new ArrayList<>();
            if(!isPathValid(path)) {
                return fileNodes;
            }
            
            FileTreeNode file = root;

            if(path.equals("/")) {
                return new ArrayList<>(root.fileTreeNodes.keySet());
            }

            String[] dirs = path.split("/");
            for(int i = 1; i < dirs.length; i ++) {
                file = file.fileTreeNodes.get(dirs[i]);
            }

            if(file.isfile) {
                fileNodes.add(dirs[dirs.length - 1]);
                return fileNodes;
            }

            fileNodes.addAll(file.fileTreeNodes.keySet());
            Collections.sort(fileNodes);
            return fileNodes;
        }

        boolean isPathValid(String path) {
            Pattern pattern = Pattern.compile("^/|(/[a-zA-Z0-9_-]+)+$"); 
            if(path == null || path.trim().isEmpty() || pattern.matcher(path).matches()) {
                return false;
            }
            return true;
        }
        
        public void mkdir(String path) {
            if(!isPathValid(path)) {
                return;
            }
            
            FileTreeNode fileNode = root;
            String dirs[] = path.split(LINUX_PATH_SEPARATOR);
            for(int i = 0; i < dirs.length; i ++) {
                if(!fileNode.fileTreeNodes.containsKey(dirs[i])) {
                    fileNode.fileTreeNodes.put(dirs[i], new FileTreeNode(false));
                } 
                fileNode = fileNode.fileTreeNodes.get(dirs[i]);
            }
            
        }
        
        public void addContentToFile(String filePath, String content) {
            if(!isPathValid(filePath)) {
                return;
            }
           
            FileTreeNode fileNode = root;
            String dirs[] = filePath.split(LINUX_PATH_SEPARATOR);
            String fileName = dirs[dirs.length - 1];
            for(int i = 0; i < dirs.length - 1; i ++) {
                fileNode = fileNode.fileTreeNodes.get(dirs[i]);
            }

            FileTreeNode file = fileNode.fileTreeNodes.getOrDefault(fileName, new FileTreeNode(true));
            file.content.concat(content);
            fileNode.fileTreeNodes.put(fileName, file);
        }
        
        public String readContentFromFile(String filePath) {
            if(!isPathValid(filePath)) {
                return "";
            }
           
            FileTreeNode fileNode = root;
            String dirs[] = filePath.split(LINUX_PATH_SEPARATOR);
            String fileName = dirs[dirs.length - 1];
            for(int i = 0; i < dirs.length - 1; i ++) {
                fileNode = fileNode.fileTreeNodes.get(dirs[i]);
            }

            return fileNode.fileTreeNodes.getOrDefault(fileName, new FileTreeNode(true)).content;

        }


}