package com.juan.marvelpedia.utils;


import com.juan.marvelpedia.modelCharacter.RetrofitMarvelResponseCharacter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//interfaz la cual reliaza la consulta de personajes a traves del nombre
public interface CustomRetrofitServiceCharacter {
    @GET("/v1/public/characters")
    Call<RetrofitMarvelResponseCharacter> getCharacterByName(@Query("nameStartsWith") String nameStartsWith,
                                                             @Query("orderBy") String orderBy,

                                                             @Query("offset") int offset,
                                                             @Query("apikey") String api_key,
                                                             @Query("ts") String ts,
                                                             @Query("hash") String hash);
}
