package com.kazimasum.apifetchdemo;

public class model
{
   String id, name, desig, image;

    public model() {
    }

    public model(String id, String name, String desig, String image) {
        this.id = id;
        this.name = name;
        this.desig = desig;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
