package com.angel_fere.mascotas.restApi.deserializador;

import com.angel_fere.mascotas.MascotaResponse;
import com.angel_fere.mascotas.Mascotas;
import com.angel_fere.mascotas.restApi.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Angel_Fere on 18/08/2017.
 */

public class MascotaDeserializadorcambiarusuario implements JsonDeserializer<MascotaResponse> {


    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        mascotaResponse.setMascotas(deserializarMascotasJson(mascotaResponseData));
        return mascotaResponse;

    }

    private ArrayList<Mascotas> deserializarMascotasJson(JsonArray mascotaResponseData){
        ArrayList<Mascotas> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size() ; i++) {

            JsonObject mascotasResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            String id               = mascotasResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto   = mascotasResponseDataObject.get(JsonKeys.USER_FULLNAME).getAsString();
            String fotoPerfil = mascotasResponseDataObject.get(JsonKeys.PROFILE_PICTURE).getAsString();

            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(id);
            mascotaActual.setNombreCompleto(nombreCompleto);
            mascotaActual.setUrlfoto(fotoPerfil);
            mascotas.add(mascotaActual);



        }
        return  mascotas;
    }


}
