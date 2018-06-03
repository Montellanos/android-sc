package com.factorybyte.demo.models;

public class Doctor {

    public Doctor(){

    }

    public Doctor(String name){
        this.name = name;
    }


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
