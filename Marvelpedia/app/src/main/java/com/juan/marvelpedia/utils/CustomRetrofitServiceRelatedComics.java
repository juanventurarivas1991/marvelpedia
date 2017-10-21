package com.juan.marvelpedia.utils;


import com.juan.marvelpedia.modelRelatedComics.RetrofitMarvelResponseRelatedComics;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


//interfaz la cual reliaza la consulta a traves del id del persoanje y obtiene los comics relacionados
public interface CustomRetrofitServiceRelatedComics {
    @GET("/v1/public/characters/{characterId}/comics")
    Call<RetrofitMarvelResponseRelatedComics> getComicsById(@Path("characterId") int characterId,
                                                            @Query("apikey") String api_key,
                                                            @Query("ts") String ts,
                                                            @Query("hash") String hash);


}
