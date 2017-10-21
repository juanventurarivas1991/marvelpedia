
package com.juan.marvelpedia.modelCharacter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Comics {

    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("returned")
    @Expose
    private String returned;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();

    /**
     * @return The available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * @param available The available
     */
    public void setAvailable(String available) {
        this.available = available;
    }

    public Comics withAvailable(String available) {
        this.available = available;
        return this;
    }

    /**
     * @return The returned
     */
    public String getReturned() {
        return returned;
    }

    /**
     * @param returned The returned
     */
    public void setReturned(String returned) {
        this.returned = returned;
    }

    public Comics withReturned(String returned) {
        this.returned = returned;
        return this;
    }

    /**
     * @return The collectionURI
     */
    public String getCollectionURI() {
        return collectionURI;
    }

    /**
     * @param collectionURI The collectionURI
     */
    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public Comics withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    /**
     * @return The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Comics withItems(List<Item> items) {
        this.items = items;
        return this;
    }

}
