package com.juan.marvelpedia.modelCharacter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis C. González on 26/10/2016.
 * FLAG Solutions S.L.
 */
public class Characters {

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
