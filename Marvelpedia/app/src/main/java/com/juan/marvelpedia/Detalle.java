package com.juan.marvelpedia;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juan.marvelpedia.modelCharacter.RetrofitMarvelResponseCharacter;
import com.juan.marvelpedia.modelComic.RetrofitMarvelResponseComic;
import com.juan.marvelpedia.modelRelatedCharacters.RetrofitMarvelResponseRelatedCharacters;
import com.juan.marvelpedia.modelRelatedComics.RetrofitMarvelResponseRelatedComics;
import com.juan.marvelpedia.utils.CustomRetrofitServiceCharacterId;
import com.juan.marvelpedia.utils.CustomRetrofitServiceComicId;
import com.juan.marvelpedia.utils.CustomRetrofitServiceRelatedCharacters;
import com.juan.marvelpedia.utils.CustomRetrofitServiceRelatedComics;
import com.juan.marvelpedia.utils.DigestUtil;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

//Activity que muestra los datos de un personaje o comic y los comics y personajes relacionados
public class Detalle extends AppCompatActivity {

    String character = "PERSONAJE";
    String comic = "COMIC";
    String characters = "PERSONAJES";
    String comics = "COMICS";
    TextView tvFicha;
    TextView tvCC;
    public int id;
    Context contexto;

    TextView nombre;
    TextView descripcion;
    ImageView foto;
    CardView cv;
    ProgressDialog dialogoProgreso;

    String direccion = "http://gateway.marvel.com";
    String privada = "63fdd6b67c866dbfbfc31815ac36d11a96b9b143";
    String publica = "9f6fb43880e95f8269d447e0b9ec80f9";
    RecyclerView rv;
    OkHttpClient okHttpClient;

    //Método que inicializa el activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);

        cv = (CardView) findViewById(R.id.cardViewDetalle);
        nombre = (TextView) findViewById(R.id.tvDetalle);
        descripcion = (TextView) findViewById(R.id.tvDetalle2);
        foto = (ImageView) findViewById(R.id.imgDetalle);

        Intent intent = this.getIntent();
        Bundle args = intent.getExtras();


        rv = (RecyclerView) findViewById(R.id.recyclerVDetalle);
        rv.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(glm);


        id = Integer.parseInt(args.getString("id"));
        tvFicha = (TextView) findViewById(R.id.tvFicha);

        tvFicha.setBackgroundResource(R.color.primaryColor);
        tvFicha.setTextColor(Color.WHITE);


        tvCC = (TextView) findViewById(R.id.tvCharactersComics);
        tvCC.setTextColor(Color.WHITE);

        tvCC.setBackgroundResource(R.color.primaryColor);
        contexto = this;
        okHttpClient = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).build();

        if (args.getInt("tab") == 0) {
            cargarPersonaje();
            cargarComicsRelacionados();

        } else {
            cargarComic();
            cargarPersonajesRelacionados();
        }

    }

    //Método que realiza la consulta sobre un personaje a partir de su id y muestra los datos en el cardview superior
    public void cargarPersonaje() {
        dialogoProgreso = ProgressDialog.show(contexto, "Marvelpedia", "BUSCANDO....");
        findViewById(R.id.rlIdp).setVisibility(View.VISIBLE);
        rv.setAdapter(null);
        tvFicha.setText("FICHA " + character);
        tvCC.setText(comics);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(direccion).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();

        long timeStamp = System.currentTimeMillis();
        String hash = DigestUtil.md5(timeStamp + privada + publica);
        CustomRetrofitServiceCharacterId service = retrofit.create(CustomRetrofitServiceCharacterId.class);
        Call<RetrofitMarvelResponseCharacter> request = service.getCharacterById(id, publica, timeStamp + "", hash);


        request.enqueue(new Callback<RetrofitMarvelResponseCharacter>() {

            @Override
            public void onResponse(Response<RetrofitMarvelResponseCharacter> response) {
                RetrofitMarvelResponseCharacter respuestaMarvel = response.body();
                List<com.juan.marvelpedia.modelCharacter.Result> lista = respuestaMarvel.getData().getResults();
                if (lista.size() > 0) {
                    com.juan.marvelpedia.modelCharacter.Result personaje = lista.get(0);
                    nombre.setText(personaje.getName());
                    descripcion.setText(personaje.getDescription());
                    Picasso.with(contexto).load(personaje.getThumbnail().getPath() + "." + personaje.getThumbnail().getExtension()).into(foto);
                    dialogoProgreso.dismiss();


                }

            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();

                dialogoProgreso.dismiss();

            }
        });
    }

    //Método que realiza la consulta sobre un los comics relacionados con un personaje a partir de su id y muestra los datos en el recyclerview inferior
    public void cargarComicsRelacionados() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(direccion).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        CustomRetrofitServiceRelatedComics service = retrofit.create(CustomRetrofitServiceRelatedComics.class);
        long timeStamp = System.currentTimeMillis();
        String hash = DigestUtil.md5(timeStamp + privada + publica);

        Call<RetrofitMarvelResponseRelatedComics> request = service.getComicsById(id, publica, timeStamp + "", hash);

        request.enqueue(new Callback<RetrofitMarvelResponseRelatedComics>() {

            @Override
            public void onResponse(Response<RetrofitMarvelResponseRelatedComics> response) {

                RetrofitMarvelResponseRelatedComics respuestaMarvel = response.body();
                List<com.juan.marvelpedia.modelRelatedComics.Result> lista = respuestaMarvel.getData().getResults();
                RecyclerComicsRelacionados rr = new RecyclerComicsRelacionados(lista, contexto);
                rv.setAdapter(rr);
                findViewById(R.id.rlIdp).setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                findViewById(R.id.rlIdp).setVisibility(View.GONE);
            }
        });


    }
    //Método que realiza la consulta sobre un comic a partir de su id y muestra los datos en el cardview superior

    public void cargarComic() {
        dialogoProgreso = ProgressDialog.show(contexto, "Marvelpedia", "BUSCANDO....");
        findViewById(R.id.rlIdp).setVisibility(View.VISIBLE);
        tvFicha.setText("FICHA " + comic);
        tvCC.setText(characters);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(direccion).addConverterFactory(GsonConverterFactory.create()).build();
        CustomRetrofitServiceComicId service = retrofit.create(CustomRetrofitServiceComicId.class);
        long timeStamp = System.currentTimeMillis();
        String hash = DigestUtil.md5(timeStamp + privada + publica);

        Call<RetrofitMarvelResponseComic> request = service.getComicById(id, publica, timeStamp + "", hash);

        request.enqueue(new Callback<RetrofitMarvelResponseComic>() {

            @Override
            public void onResponse(Response<RetrofitMarvelResponseComic> response) {
                RetrofitMarvelResponseComic respuestaMarvel = response.body();
                List<com.juan.marvelpedia.modelComic.Result> lista = respuestaMarvel.getData().getResults();
                if (lista.size() > 0) {
                    com.juan.marvelpedia.modelComic.Result personaje = lista.get(0);
                    nombre.setText(personaje.getTitle());
                    descripcion.setText(personaje.getDescription());
                    Picasso.with(contexto).load(personaje.getThumbnail().getPath() + "." + personaje.getThumbnail().getExtension()).into(foto);
                    dialogoProgreso.dismiss();

                }

            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                dialogoProgreso.dismiss();
            }
        });

    }

    //Método que realiza la consulta sobre un los personajes relacionados con un comic a partir de su id y muestra los datos en el recyclerview inferior
    public void cargarPersonajesRelacionados() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(direccion).addConverterFactory(GsonConverterFactory.create()).build();
        CustomRetrofitServiceRelatedCharacters service = retrofit.create(CustomRetrofitServiceRelatedCharacters.class);
        long timeStamp = System.currentTimeMillis();
        String hash = DigestUtil.md5(timeStamp + privada + publica);

        Call<RetrofitMarvelResponseRelatedCharacters> request = service.getCharactersById(id, publica, timeStamp + "", hash);

        request.enqueue(new Callback<RetrofitMarvelResponseRelatedCharacters>() {

            @Override
            public void onResponse(Response<RetrofitMarvelResponseRelatedCharacters> response) {

                RetrofitMarvelResponseRelatedCharacters respuestaMarvel = response.body();
                List<com.juan.marvelpedia.modelRelatedCharacters.Result> lista = respuestaMarvel.getData().getResults();
                RecyclerCharactesrRelacionados rr = new RecyclerCharactesrRelacionados(lista, contexto);
                rv.setAdapter(rr);
                findViewById(R.id.rlIdp).setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                findViewById(R.id.rlIdp).setVisibility(View.GONE);
            }
        });


    }

}
