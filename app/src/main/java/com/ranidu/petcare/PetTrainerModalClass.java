package com.ranidu.petcare;

public class PetTrainerModalClass {
    int photo;
    String name, price;

    public PetTrainerModalClass(int photo, String price, String name) {
        this.photo = photo;
        this.price = price;
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
