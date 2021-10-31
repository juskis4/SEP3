package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class User {
    private String type;
    private Value value;

    public User(){
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue(){
        return value;
    }

    public void setValue(Value value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "com.example.consumingrest.User{" +
                "type='" + type + '\'' + "com.example.consumingrest.Value= " + value + '\'' +
                '}';
    }
}
