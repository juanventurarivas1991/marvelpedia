package com.juan.marvelpedia.utils;


import com.juan.marvelpedia.modelComic.RetrofitMarvelResponseComic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//interfaz la cual reliaza la consulta a traves del id del comic
public interface CustomRetrofitServiceComicId {
    @GET("/v1/public/comics/{comicId}")
    Call<RetrofitMarvelResponseComic> getComicById(@Path("comicId") int comicId,
                                                   @Query("apikey") String api_key,
                                                   @Query("ts") String ts,
                                                   @Query("hash") String hash);

}

