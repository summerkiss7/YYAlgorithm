package com.slam.alg.google.json;

import java.util.HashMap;

import com.slam.alg.google.json.exception.JsonTypeException;

public class JsonObject extends HashMap<String, Object> {

    public JsonObject getJsonObject(String key) {
        if (!this.containsKey(key)) {
            throw new IllegalArgumentException("Invalid key");
        }

        Object obj = this.get(key);
        if (!(obj instanceof JsonObject)) {
            throw new JsonTypeException("Type of value is not JsonObject");
        }

        return (JsonObject) obj;
    }

    public JsonArray getJsonArray(String key) {
        if(!this.containsKey(key)) {
           throw new IllegalArgumentException("Invalid key");
        }

        Object obj = this.get(key);
        if(obj instanceof JsonArray) {
            throw new JsonTypeException("is not JsonArray");
        }

        return (JsonArray) obj;
    }
}
