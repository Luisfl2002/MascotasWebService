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
 * Created by Angel_Fere on 14/08/2017.
 */

public class MascotaDeserializador  implements JsonDeserializer<MascotaResponse>{


    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarMascotasJson(mascotaResponseData));
        return mascotaResponse;

    }

    private ArrayList<Mascotas>deserializarMascotasJson(JsonArray mascotasRespondeData){
        ArrayList<Mascotas> contactos = new ArrayList<>();
        for (int i = 0; i < mascotasRespondeData.size() ; i++) {
            JsonObject contactoResponseDataObject = mascotasRespondeData.get(i).getAsJsonObject();

            JsonObject userJson     = contactoResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id               = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto   = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson            = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto                  = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Mascotas contactoActual = new Mascotas();
            contactoActual.setId(id);
            contactoActual.setNombreCompleto(nombreCompleto);
            contactoActual.setUrlfoto(urlFoto);
            contactoActual.setLikes(likes);

            contactos.add(contactoActual);

        }

        return contactos;

    }



}
