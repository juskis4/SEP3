package com.example.consumingrest;

public class Value {
    private Long id;
    private String userResources;

    public Value(){

    }

    public Long getId() {
        return id;
    }

    public String getUserResources() {
        return userResources;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserResources(String userResources) {
        this.userResources = userResources;
    }

}
