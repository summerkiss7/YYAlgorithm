package com.slam.alg.google.json;

import java.io.IOException;
import java.io.Reader;

public class CharReader {
    private Reader reader;
    private char[] buffer;
    final static int BUFFER_SIZE = 1024;
    private int pos;
    private int size;

    public CharReader(Reader reader) {
        this.reader = reader;
        buffer = new char[BUFFER_SIZE];
    }

    public char peek() {
        if(pos - 1 >= size) {
            return (char) -1;
        }

        return buffer[Math.max(0, pos -1)];
    }

    public char next() throws IOException{
        if(!hasMore()) {
            return (char) -1;
        }

        return buffer[pos++];
    }

    public boolean hasMore() throws IOException {
        if(pos < size) {
            return true;
        }

        fillBuffer();
        return pos < size;
    }

    void fillBuffer() throws IOException {
        int n = reader.read(buffer);
        if( n == -1) {
            return;
        }
        pos = 0;
        size = n;
     }

     public void back() {
         pos = Math.max(0, pos--);
     }
    public static void main (String args[]) {
        System.out.println((char) -1);
    }

}
