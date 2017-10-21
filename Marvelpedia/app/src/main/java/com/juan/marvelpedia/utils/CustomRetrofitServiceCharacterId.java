package com.juan.marvelpedia.utils;


import com.juan.marvelpedia.modelCharacter.RetrofitMarvelResponseCharacter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//interfaz la cual reliaza la consulta a traves del id del personaje
public interface CustomRetrofitServiceCharacterId {
    @GET("/v1/public/characters/{characterId}")
    Call<RetrofitMarvelResponseCharacter> getCharacterById(@Path("characterId") int characterId,
                                                           @Query("apikey") String api_key,
                                                           @Query("ts") String ts,
                                                           @Query("hash") String hash);

}
