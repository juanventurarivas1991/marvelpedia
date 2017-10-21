package com.juan.marvelpedia;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.juan.marvelpedia.modelRelatedComics.Result;
import com.squareup.picasso.Picasso;

import java.util.List;


//Clase la cual llama a la interfaz de busqueda del servicio
//y mustra los datos de la busqueda por pantalla

public class RecyclerComicsRelacionados extends RecyclerView.Adapter<RecyclerComicsRelacionados.RelacionadoViewHolder> {
    List<Result> resultados;

    Context context;
    // Allows to remember the last item shown on screen
    private int lastPosition = -1;

    RecyclerComicsRelacionados(List<Result> resultados, Context context) {
        this.resultados = resultados;
        this.context = context;
    }

    @Override
    public RecyclerComicsRelacionados.RelacionadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.relacionados, parent, false);
        //Inicializamos el ViewHolder con la vista
        RecyclerComicsRelacionados.RelacionadoViewHolder pvh = new RecyclerComicsRelacionados.RelacionadoViewHolder(v);
        //Devolvemos el ViewHolder inicializado
        return pvh;
    }

    @Override
    public void onBindViewHolder(RecyclerComicsRelacionados.RelacionadoViewHolder holder, final int position) {
        //Asignamos los datos del Array a cada ViewHolder de la lista
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((Detalle) context).id = Integer.parseInt(resultados.get(position).getId());
                ((Detalle) context).cargarComic();
                ((Detalle) context).cargarPersonajesRelacionados();


            }
        });
        holder.nombre.setText(resultados.get(position).getTitle());

        Picasso.with(context).load(resultados.get(position).getThumbnail().getPath() + "." + resultados.get(position).getThumbnail().getExtension()).into(holder.foto);

        setAnimation(holder.cv, position);
    }

    @Override
    public int getItemCount() {
        //Establecemos el total de elementos en función del tamaño de nuestro Array de Objetos

        return resultados.size();
    }

    public static class RelacionadoViewHolder extends RecyclerView.ViewHolder {
        //Declaramos los atributos de nuestro ViewHolder

        CardView cv;
        TextView nombre;
        ImageView foto;


        RelacionadoViewHolder(View itemView) {
            super(itemView);
            //Inicializamos los widgets de nuestro ViewHolder
            cv = (CardView) itemView.findViewById(R.id.cardViewRelacionado);
            nombre = (TextView) itemView.findViewById(R.id.tvRelacionados);
            foto = (ImageView) itemView.findViewById(R.id.imgRelacionados);


        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
