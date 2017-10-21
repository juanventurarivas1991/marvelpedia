
package com.juan.marvelpedia.modelCharacter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("urls")
    @Expose
    private List<Url> urls = new ArrayList<Url>();
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("comics")
    @Expose
    private Comics comics;
    @SerializedName("stories")
    @Expose
    private Stories stories;
    @SerializedName("events")
    @Expose
    private Events events;
    @SerializedName("series")
    @Expose
    private Series series;

    @SerializedName("characters")
    @Expose
    private Characters characters;

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Result withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Result withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Result withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * @return The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * @param modified The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    public Result withModified(String modified) {
        this.modified = modified;
        return this;
    }

    /**
     * @return The resourceURI
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     * @param resourceURI The resourceURI
     */
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Result withResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    /**
     * @return The urls
     */
    public List<Url> getUrls() {
        return urls;
    }

    /**
     * @param urls The urls
     */
    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public Result withUrls(List<Url> urls) {
        this.urls = urls;
        return this;
    }

    /**
     * @return The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Result withThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    /**
     * @return The comics
     */
    public Comics getComics() {
        return comics;
    }

    /**
     * @param comics The comics
     */
    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public Result withComics(Comics comics) {
        this.comics = comics;
        return this;
    }

    /**
     * @return The stories
     */
    public Stories getStories() {
        return stories;
    }

    /**
     * @param stories The stories
     */
    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public Result withStories(Stories stories) {
        this.stories = stories;
        return this;
    }

    /**
     * @return The events
     */
    public Events getEvents() {
        return events;
    }

    /**
     * @param events The events
     */
    public void setEvents(Events events) {
        this.events = events;
    }

    public Result withEvents(Events events) {
        this.events = events;
        return this;
    }

    /**
     * @return The series
     */
    public Series getSeries() {
        return series;
    }

    /**
     * @param series The series
     */
    public void setSeries(Series series) {
        this.series = series;
    }

    public Result withSeries(Series series) {
        this.series = series;
        return this;
    }

}
