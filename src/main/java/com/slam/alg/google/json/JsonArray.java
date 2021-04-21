package com.slam.alg.google.json;
import java.util.*;

import com.slam.alg.google.json.exception.JsonTypeException;

public class JsonArray extends ArrayList<Object> { 

    public JsonObject getJosnObject(int index) {
        Object obj = this.get(index);
        if(!(obj instanceof JsonObject)) {
            throw new JsonTypeException("not JsonObject");
        }
        return (JsonObject) obj;
    }

    public JsonArray getJsonArray(int index) {
        Object obj = this.get(index);
        if (!(obj instanceof JsonArray)) {
            throw new JsonTypeException("Type of value is not JsonArray");
        }

        return (JsonArray) obj;
    }
}
