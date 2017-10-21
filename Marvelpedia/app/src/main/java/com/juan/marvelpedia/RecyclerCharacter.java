package com.juan.marvelpedia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.juan.marvelpedia.modelCharacter.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

//Clase la cual llama a la interfaz de busqueda del servicio
//y mustra los datos de la busqueda por pantalla
public class RecyclerCharacter extends RecyclerView.Adapter<RecyclerCharacter.CharacterViewHolder> {

    List<Result> resultados;

    Context context;


    RecyclerCharacter(List<Result> resultados, Context context) {
        this.resultados = resultados;
        this.context = context;
    }


    @Override
    //Método que inicializa cardview inflado
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inicializamos nuestra Vista a partir del layout de CardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        //Inicializamos el ViewHolder con la vista
        CharacterViewHolder pvh = new CharacterViewHolder(v);
        //Devolvemos el ViewHolder inicializado
        return pvh;
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, final int position) {

        //Asignamos los datos del Array a cada ViewHolder de la lista
        holder.nombre.setText(resultados.get(position).getName());
        holder.descripcion.setText(resultados.get(position).getDescription());
        Picasso.with(context).load(resultados.get(position).getThumbnail().getPath() + "." + resultados.get(position).getThumbnail().getExtension()).into(holder.foto);


        // holder.cv.setBackgroundResource(R.color.accentColor);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Detalle.class);

                Bundle args = new Bundle();
                args.putString("id", resultados.get(position).getId());
                args.putInt("tab", 0);

                intent.putExtras(args);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        //Establecemos el total de elementos en función del tamaño de nuestro Array
        return resultados.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        //Declaramos los atributos de nuestro ViewHolder
        CardView cv;
        TextView nombre;
        TextView descripcion;
        ImageView foto;

        CharacterViewHolder(View itemView) {
            super(itemView);
            //Inicializamos los widgets de nuestro ViewHolder
            cv = (CardView) itemView.findViewById(R.id.cardView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombre);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
            foto = (ImageView) itemView.findViewById(R.id.imgFoto);

        }
    }
}

