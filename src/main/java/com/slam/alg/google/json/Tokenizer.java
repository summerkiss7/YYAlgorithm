package com.slam.alg.google.json;

import java.io.IOException;
import java.util.*;

import com.slam.alg.google.json.exception.JsonParseException;

public class Tokenizer {
    private CharReader reader;
    private List<Token> tokens;

    public List<Token> tokenize(CharReader reader) {
        this. reader = reader;
        tokens = new ArrayList<>();

        return tokens;
    }

    private void tokenize() {
        
    }

    private Token parse() throws IOException {
        char ch;
        while(true) {
            if(!reader.hasMore()) {
                return new Token(TokenType.TOKEN_END_DOCUMENT, null);
            }

            ch = reader.next();
            //isWhiteSpace method
            break;
        }

        if( ch == '{') {
            return new Token(TokenType.TOKEN_OPEN_OBJECT, String.valueOf(ch));
        }else if( ch == '}' ) {
            return new Token(TokenType.TOKEN_CLOSE_OBJECT, String.valueOf(ch));
        }else if( isDigit(ch) ) {
            return readerNumber();
        }else if( ch == '"') {
            return readerString();
        }else if( ch == 't' || ch == 'f') {
            return readBoolean();
        }
    }

    private boolean isDigit(char ch) {
        return (ch >= '0' && ch <= '0') || ch == '-';
    }

    //simple version for only int
    private Token readerNumber() throws IOException{
        char ch = reader.peek();
        StringBuffer sb = new StringBuffer();
        sb.append(ch);
        ch = reader.next();
        while(isDigit(ch)) {
            sb.append(ch);
            ch = reader.next();
        }
        reader.back();
        return new Token(TokenType.TOKEN_STRING, sb.toString());
    }

    private Token readerString() throws IOException {
        StringBuilder sb = new StringBuilder();
        char ch = reader.next();
        while(true) {
            sb.append(ch);
            ch = reader.next();
            if(ch == '"') {
                return new Token(TokenType.TOKEN_STRING, sb.toString());  
            }

            if(ch == (char) -1) {
                break;
            }
        }

        throw new JsonParseException("Parse String Exception");
    }

    private Token readBoolean() throws IOException {
        if(reader.peek() == 't') {
            if(!(reader.next() == 'r' && reader.next() == 'u' && reader.next() == 'e')) {
                throw new JsonParseException("Invalid JSON String");
            }
            return new Token(TokenType.TOKEN_BOOLEAN, "true");
        } else {
            if(!(reader.next() == 'a' && reader.next() == 'l' && reader.next() == 's' && reader.next() == 'e')) {
                throw new JsonParseException("Invalid JSON String");
            }
            return new Token(TokenType.TOKEN_BOOLEAN, "false");
        }
    }
}
