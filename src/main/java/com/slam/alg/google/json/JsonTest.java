package com.slam.alg.google.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class JsonTest {
    public static void main(String args[]) throws IOException {
        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        // "{  \"firstName\" : \"John\", \"lastName\" : \"Smith\", \"age\": 25," + 
        //   " \"address\" : { \"streetAddress\" : \"21 2nd Street\", \"city\" : \"New York\", \"state\" : \"NY\", \"postalCode\" : 10021 }," +
        //     "\"phoneNumbers\":[" + "{ \"type\": \"home\",\"number\": \"212 555-1234\" }, { \"type\": \"fax\", \"number\": \"646 555-4567\" }" +
            
        //   "] }";

        JsonFactory factory = new JsonFactory();
        JsonParser parser  = factory.createParser(carJson);
        while(!parser.isClosed()){
            JsonToken jsonToken = parser.nextToken();

            System.out.println("jsonToken = " + jsonToken);
        }
    }
}
