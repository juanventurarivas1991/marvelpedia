package com.juan.marvelpedia.utils;

import com.juan.marvelpedia.modelRelatedCharacters.RetrofitMarvelResponseRelatedCharacters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


//interfaz la cual reliaza la consulta a traves del id del comic y obtien los perosanjes relacionados
public interface CustomRetrofitServiceRelatedCharacters {
    @GET("/v1/public/comics/{comicId}/characters")
    Call<RetrofitMarvelResponseRelatedCharacters> getCharactersById(@Path("comicId") int comicId,
                                                                    @Query("apikey") String api_key,
                                                                    @Query("ts") String ts,
                                                                    @Query("hash") String hash);


}