package com.angel_fere.mascotas;

import java.util.ArrayList;

/**
 * Created by Angel_Fere on 02/08/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();

    public mascotasAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(mascotasAdaptador  adaptador);

}
