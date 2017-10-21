
package com.juan.marvelpedia.modelCharacter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("limit")
    @Expose
    private String limit;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();

    /**
     * @return The offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * @param offset The offset
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Data withOffset(String offset) {
        this.offset = offset;
        return this;
    }

    /**
     * @return The limit
     */
    public String getLimit() {
        return limit;
    }

    /**
     * @param limit The limit
     */
    public void setLimit(String limit) {
        this.limit = limit;
    }

    public Data withLimit(String limit) {
        this.limit = limit;
        return this;
    }

    /**
     * @return The total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(String total) {
        this.total = total;
    }

    public Data withTotal(String total) {
        this.total = total;
        return this;
    }

    /**
     * @return The count
     */
    public String getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(String count) {
        this.count = count;
    }

    public Data withCount(String count) {
        this.count = count;
        return this;
    }

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Data withResults(List<Result> results) {
        this.results = results;
        return this;
    }

}
