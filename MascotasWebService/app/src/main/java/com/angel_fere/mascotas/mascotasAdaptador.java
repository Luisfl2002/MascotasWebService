package com.angel_fere.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.angel_fere.mascotas.Mascotas;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class mascotasAdaptador extends RecyclerView.Adapter<mascotasAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public mascotasAdaptador(ArrayList<Mascotas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);

        Picasso.with(activity)
                .load(mascota.getUrlfoto())
                .placeholder(R.drawable.rayo)
                .into(mascotaViewHolder.imgFoto);


        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, Detalle_mascota.class);
                intent.putExtra("url", mascota.getUrlfoto());
                intent.putExtra("like", mascota.getLikes());

                activity.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;

        private TextView tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);

            tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}