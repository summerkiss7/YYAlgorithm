package com.slam.alg.google.json;

public class Token {
    public Token(TokenType tokenType, String value) {
        this.type = tokenType;
        this.value = value;
    }
    public TokenType type;
    public TokenType getType() {
        return type;
    }
    public void setType(TokenType type) {
        this.type = type;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String value;
}
