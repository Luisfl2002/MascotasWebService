package com.angel_fere.mascotas.restApi.adapter;

import com.angel_fere.mascotas.MascotaResponse;
import com.angel_fere.mascotas.restApi.ConstantesRestApi;
import com.angel_fere.mascotas.restApi.EndpointsApi;
import com.angel_fere.mascotas.restApi.deserializador.MascotaDeserializador;
import com.angel_fere.mascotas.restApi.deserializador.MascotaDeserializadorcambiarusuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Angel_Fere on 14/08/2017.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return  retrofit.create(EndpointsApi.class);



    }

    public Gson contruyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();


    }

    public Gson construyeGsonDeserializadorcambiarusuario(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializadorcambiarusuario());
        return gsonBuilder.create();




    }

}
