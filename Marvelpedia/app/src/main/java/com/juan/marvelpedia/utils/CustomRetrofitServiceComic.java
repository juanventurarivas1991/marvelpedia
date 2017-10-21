package com.juan.marvelpedia.utils;


import com.juan.marvelpedia.modelComic.RetrofitMarvelResponseComic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


//interfaz la cual reliaza la consulta de comics a traves del título
public interface CustomRetrofitServiceComic {
    @GET("/v1/public/comics")
    Call<RetrofitMarvelResponseComic> getComicByTitle(@Query("titleStartsWith") String titleStartsWith,
                                                      @Query("orderBy") String orderBy,

                                                      @Query("offset") int offset,
                                                      @Query("apikey") String api_key,
                                                      @Query("ts") String ts,
                                                      @Query("hash") String hash);
}

