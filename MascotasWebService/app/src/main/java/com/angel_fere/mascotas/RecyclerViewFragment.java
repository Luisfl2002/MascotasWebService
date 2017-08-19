package com.angel_fere.mascotas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angel_fere.mascotas.presentador.IRecyclerViewFragmentPresenter;
import com.angel_fere.mascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Angel_Fere on 25/07/2017.
 */

public class RecyclerViewFragment extends Fragment implements  IRecyclerViewFragmentView{

    ArrayList<Mascotas> mascotas;
    RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_mascota, container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvfmascotas);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;
    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager l = new LinearLayoutManager(getActivity());
        l.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(l);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new  GridLayoutManager(getContext(),2);
        listaMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public mascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        mascotasAdaptador adaptador = new mascotasAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(mascotasAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }







}