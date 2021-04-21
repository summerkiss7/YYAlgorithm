package com.slam.alg.google.json.parser;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.slam.alg.google.json.JsonArray;
import com.slam.alg.google.json.JsonObject;
import com.slam.alg.google.json.Token;
import com.slam.alg.google.json.TokenType;
import com.slam.alg.google.json.exception.JsonParseException;

public class Parser {

    private List<Token> tokens;
    private int pos;
    private int size;

    public Object parse(List<Token> tokens) {
        this.tokens = tokens;
        pos = 0;
        size = tokens.size();
        return parse();
    }

    private Object parse() {
        Token token = tokens.get(pos++);
        if(token == null) {
            return new JsonObject();
        }else if(token.type == TokenType.TOKEN_OPEN_OBJECT) {
            return parseJsonObject();
        }else if(token.type == TokenType.TOKEN_OPEN_ARRAY) {
            return parseJsonArray();
        }else{
            throw new JsonParseException("Parse error, invalid Token.");
        }
    }

    //"{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
    public JsonObject parseJsonObject() {
        JsonObject jsonObject = new JsonObject();
        int expectToken = TokenType.TOKEN_CLOSE_OBJECT.getTokenCode() | TokenType.TOKEN_STRING.getTokenCode();
        String key = null;
        String value = null;
        
        while(pos < size) {
            Token token = tokens.get(pos++);
        }
        return null;
    }

    public JsonArray parseJsonArray() {
        return null;
    }
    
    
}
