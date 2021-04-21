package com.slam.alg.google.json;

public enum TokenType {
    TOKEN_OPEN_OBJECT(1), //{
    TOKEN_CLOSE_OBJECT(2),//}
    TOKEN_OPEN_ARRAY(4),//[
    TOKEN_CLOSE_ARRAY(8),//]
    TOKEN_NULL(16),
    TOKEN_NUMBER(32),
    TOKEN_STRING(64),
    TOKEN_BOOLEAN(128),
    TOKEN_COLON(256),
    TOKEN_COMA(512),
    TOKEN_END_DOCUMENT(1024);

    private int code;

    TokenType(int code) {
        this.code = code;
    }

    public int getTokenCode() {
        return this.code;
    }
}
