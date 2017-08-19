package com.angel_fere.mascotas.presentador;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.angel_fere.mascotas.IRecyclerViewFragmentView;
import com.angel_fere.mascotas.MascotaResponse;
import com.angel_fere.mascotas.Mascotas;
import com.angel_fere.mascotas.db.ConstructorMascotas;
import com.angel_fere.mascotas.mascotasAdaptador;
import com.angel_fere.mascotas.restApi.ConstantesRestApi;
import com.angel_fere.mascotas.restApi.EndpointsApi;
import com.angel_fere.mascotas.restApi.JsonKeys;
import com.angel_fere.mascotas.restApi.adapter.RestApiAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Angel_Fere on 02/08/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;
    String usuarioID;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
       // obtenerMascotasBaseDatos();

    obtenerMediosRecientes();

    }



    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas =  new ConstructorMascotas(context);
        mascotas =constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMediosRecientes() {


        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.contruyeGsonDeserializadorMediaRecent();
       EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
       SharedPreferences preferences = context.getApplicationContext().getSharedPreferences("datos",Context.MODE_PRIVATE);
        usuarioID = preferences.getString(JsonKeys.USER_ID,"5852498186");
      //  EndpointsApi endpointsApi1 = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia(usuarioID,ConstantesRestApi.ACCESS_TOKEN);



        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse contactoResponse = response.body();
                mascotas = contactoResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });


    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
