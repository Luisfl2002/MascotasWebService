package com.angel_fere.mascotas;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.angel_fere.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;

/**
 * Created by Angel_Fere on 20/07/2017.
 */

public class Mascotas_favoritas  extends AppCompatActivity{

    ArrayList<Mascotas> mascotas;
    RecyclerView rmascotas;
    private ConstructorMascotas constructorMascotas;
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_grid_mascotas);
        rmascotas = (RecyclerView) findViewById(R.id.rvfprincipal);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager


    }
*/



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);
        rmascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager linear = new LinearLayoutManager(this);
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        rmascotas.setLayoutManager(linear);
        losFavoritos();
        inicializarAdaptador();

    }



    public void inicializarListaMascotas(){
       /* mascotas = new ArrayList<>();
        mascotas.add(new Mascotas(R.drawable.gatito,"Alex",5, 1));
        mascotas.add(new Mascotas(R.drawable.salchicha,"Benji",10, 2));
        mascotas.add(new Mascotas(R.drawable.peque_ito,"Little",3, 3));
        mascotas.add(new Mascotas(R.drawable.pug,"Gorila",8, 4));
        mascotas.add(new Mascotas(R.drawable.lanudo,"Lanudo",7, 5));*/


    }

    public void inicializarAdaptador(){

        mascotasAdaptador adaptador = new mascotasAdaptador(mascotas,this);
        rmascotas.setAdapter(adaptador);

    }

    public void losFavoritos(){
       constructorMascotas = new ConstructorMascotas(this);
        mascotas = constructorMascotas.sacarFavoritos();

    }

    





}
