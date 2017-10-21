
package com.juan.marvelpedia.modelComic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrofitMarvelResponseComic {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("attributionText")
    @Expose
    private String attributionText;
    @SerializedName("attributionHTML")
    @Expose
    private String attributionHTML;
    @SerializedName("data")
    @Expose
    private com.juan.marvelpedia.modelComic.Data data;
    @SerializedName("etag")
    @Expose
    private String etag;

    /**
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public RetrofitMarvelResponseComic withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public RetrofitMarvelResponseComic withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * @return The copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * @param copyright The copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public RetrofitMarvelResponseComic withCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    /**
     * @return The attributionText
     */
    public String getAttributionText() {
        return attributionText;
    }

    /**
     * @param attributionText The attributionText
     */
    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public RetrofitMarvelResponseComic withAttributionText(String attributionText) {
        this.attributionText = attributionText;
        return this;
    }

    /**
     * @return The attributionHTML
     */
    public String getAttributionHTML() {
        return attributionHTML;
    }

    /**
     * @param attributionHTML The attributionHTML
     */
    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public RetrofitMarvelResponseComic withAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
        return this;
    }

    /**
     * @return The data
     */
    public com.juan.marvelpedia.modelComic.Data getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(com.juan.marvelpedia.modelComic.Data data) {
        this.data = data;
    }

    public RetrofitMarvelResponseComic withData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * @return The etag
     */
    public String getEtag() {
        return etag;
    }

    /**
     * @param etag The etag
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    public RetrofitMarvelResponseComic withEtag(String etag) {
        this.etag = etag;
        return this;
    }

}
