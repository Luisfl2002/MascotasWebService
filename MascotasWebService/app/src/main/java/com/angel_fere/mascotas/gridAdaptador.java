package com.angel_fere.mascotas;

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;



/**
 * Created by Angel_Fere on 25/07/2017.
 */

public class gridAdaptador extends RecyclerView.Adapter<gridAdaptador.GridViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity activity;


    public gridAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;

    }


    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_mascotas,parent,false);
        return new GridViewHolder(v);

    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        final Mascotas mascota = mascotas.get(position);
      //  holder.gimgMascotas.setImageResource(mascota.getUrlfoto());
        holder.glikes.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView gimgMascotas;
        private TextView glikes;

        public GridViewHolder(View itemView) {
            super(itemView);
            gimgMascotas =  itemView.findViewById(R.id.imgMascota);
            glikes = itemView.findViewById(R.id.tvLikes);
        }
    }


}