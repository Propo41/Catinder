package com.example.catinder;

public class CatProfile {
    private String name;
    private String age;
    private String gender;
    private int image;

    public CatProfile(String name, String age, String gender, int image) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
