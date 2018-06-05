package com.factorybyte.demo.models;

public class Doctor {

    private String name;
    private String image;
    private int telephone;



    public Doctor(){

    }

    public Doctor(String name, String image, int telephone){

        this.name = name;

        this.telephone = telephone;

        this.image = image;


    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
