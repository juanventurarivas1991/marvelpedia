package com.juan.marvelpedia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juan.marvelpedia.modelCharacter.RetrofitMarvelResponseCharacter;
import com.juan.marvelpedia.modelComic.RetrofitMarvelResponseComic;
import com.juan.marvelpedia.utils.CustomRetrofitServiceCharacter;
import com.juan.marvelpedia.utils.CustomRetrofitServiceComic;
import com.juan.marvelpedia.utils.DigestUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


//Fragment que controla la vista de las búsquedas de personajes y comics
public class FragmentControlador extends Fragment {

    Button btnBuscar;
    TextInputLayout tilBuscar;
    String direccion = "http://gateway.marvel.com";
    String privada = "63fdd6b67c866dbfbfc31815ac36d11a96b9b143";
    String publica = "9f6fb43880e95f8269d447e0b9ec80f9";
    Context contexto;
    RecyclerView rv;
    ProgressDialog dialogoProgreso;
    AlertDialog dialogoAlerta;
    OkHttpClient okHttpClient;


    @Override
    //Método que inicializa el Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Creamos la vista inflando desde XML
        View rootView = inflater.inflate(
                R.layout.fragment, container, false);
        contexto = this.getContext();
        //Tomamos el TextView de la vista del Fragment(rootview)
        tilBuscar = (TextInputLayout) rootView.findViewById(R.id.inputTextLayoutBuscar);


        btnBuscar = (Button) rootView.findViewById(R.id.btnBuscar);
        okHttpClient = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).build();
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tilBuscar.getEditText().getText().length() > 0) {
                    dialogoProgreso = ProgressDialog.show(contexto, "Marvelpedia", "BUSCANDO....");
                    AlertDialog.Builder construtorAD = new AlertDialog.Builder(contexto);
                    construtorAD.setTitle("Error");
                    construtorAD.setMessage("Fallo en la conexión con el servicio.");
                    construtorAD.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {

                        }

                    });

                    dialogoAlerta = construtorAD.create();

                    Bundle args = getArguments();
                    if (args.getInt("pos") == 0) {
                        buscarPersonaje();
                    } else {
                        buscarComic();
                    }
                }

            }
        });


        rv = (RecyclerView) rootView.findViewById(R.id.recyclerV);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(contexto);
        rv.setLayoutManager(llm);
        return rootView;

    }

    //Método que realiza la consulta sobre un o unos personajes y muestra los datos en el cardview superior
    private void buscarPersonaje() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(direccion).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        CustomRetrofitServiceCharacter service = retrofit.create(CustomRetrofitServiceCharacter.class);
        long timeStamp = System.currentTimeMillis();
        String hash = DigestUtil.md5(timeStamp + privada + publica);

        Call<RetrofitMarvelResponseCharacter> request = service.getCharacterByName(tilBuscar.getEditText().getText().toString(), "name", 0, publica, timeStamp + "", hash);


        request.enqueue(new Callback<RetrofitMarvelResponseCharacter>() {

            @Override
            public void onResponse(Response<RetrofitMarvelResponseCharacter> response) {

                RetrofitMarvelResponseCharacter respuestaMarvel = response.body();
                RecyclerCharacter adptRc = new RecyclerCharacter(respuestaMarvel.getData().getResults(), contexto);

                rv.setAdapter(adptRc);

                dialogoProgreso.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                dialogoProgreso.dismiss();
                dialogoAlerta.show();

            }
        });
    }

    //Método que realiza la consulta sobre un o unos comics y muestra los datos en el cardview superior
    private void buscarComic() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(direccion).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        CustomRetrofitServiceComic service = retrofit.create(CustomRetrofitServiceComic.class);
        long timeStamp = System.currentTimeMillis();
        String hash = DigestUtil.md5(timeStamp + privada + publica);

        Call<RetrofitMarvelResponseComic> request = service.getComicByTitle(tilBuscar.getEditText().getText().toString(), "title", 0, publica, timeStamp + "", hash);


        request.enqueue(new Callback<RetrofitMarvelResponseComic>() {

            @Override
            public void onResponse(Response<RetrofitMarvelResponseComic> response) {
                RetrofitMarvelResponseComic respuestaMarvel = response.body();
                RecyclerComic adptRc = new RecyclerComic(respuestaMarvel.getData().getResults(), contexto);
                rv.setAdapter(adptRc);
                dialogoProgreso.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
                dialogoProgreso.dismiss();
                dialogoAlerta.show();
            }
        });
    }


}




