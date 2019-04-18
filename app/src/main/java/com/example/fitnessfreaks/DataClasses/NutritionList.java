package com.example.fitnessfreaks.DataClasses;

public class NutritionList {
    public String name , protien , qnt , fat , carbs ;

    public NutritionList(String name,String qnt, String protien, String fat, String carbs) {
        this.name = name;
        this.qnt = qnt;
        this.protien = protien;
        this.fat = fat;
        this.carbs = carbs;
    }

    public String getQnt() {
        return qnt;
    }

    public void setQnt(String qnt) {
        this.qnt = qnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtien() {
        return protien;
    }

    public void setProtien(String protien) {
        this.protien = protien;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }
}
