package com.example.fitnessfreaks.DataClasses;

import android.widget.ImageView;
import android.widget.TextView;

public class excersice {
    String excersiceImage;
    String excersiceName;

    public excersice(String excersiceImage, String excersiceName) {
        this.excersiceImage = excersiceImage;
        this.excersiceName = excersiceName;
    }

    public String getExcersiceImage() {
        return excersiceImage;
    }

    public void setExcersiceImage(String excersiceImage) {
        this.excersiceImage = excersiceImage;
    }

    public String getExcersiceName() {
        return excersiceName;
    }

    public void setExcersiceName(String excersiceName) {
        this.excersiceName = excersiceName;
    }
}
