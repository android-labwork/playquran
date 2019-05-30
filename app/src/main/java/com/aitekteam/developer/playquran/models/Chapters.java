package com.aitekteam.developer.playquran.models;

import com.aitekteam.developer.playquran.data.Chapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Chapters implements Serializable {
    @SerializedName("chapters")
    private ArrayList<Chapter> items;

    public ArrayList<Chapter> getItems() {
        return items;
    }

    public void setItems(ArrayList<Chapter> items) {
        this.items = items;
    }
}
