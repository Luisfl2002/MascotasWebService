package com.angel_fere.mascotas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.angel_fere.mascotas.restApi.ConstantesRestApi;
import com.angel_fere.mascotas.restApi.EndpointsApi;
import com.angel_fere.mascotas.restApi.JsonKeys;
import com.angel_fere.mascotas.restApi.adapter.RestApiAdapter;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class configurar_cuenta extends AppCompatActivity {

    private  TextView Instagram;
    private String usuario_instagram;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);
        Instagram = (TextView) findViewById(R.id.tv_instagram);
    }

    public void cambiar_usuario(View view){

        usuario_instagram = Instagram.getText().toString();

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsoncambiar_usuario = restApiAdapter.construyeGsonDeserializadorcambiarusuario();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsoncambiar_usuario);
        final Call<MascotaResponse> mascotaResponseCall = endpointsApi.search(usuario_instagram,ConstantesRestApi.ACCESS_TOKEN);



        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {

                Mascotas mascotas = response.body().getMascotas().get(0);

                if(mascotas == null){

                    Toast.makeText(getApplicationContext(), "No se encuentra la aplicacion", Toast.LENGTH_SHORT).show();
                }
                else {

                    response.body().getMascotas().get(0);
                    Intent intent = new Intent(configurar_cuenta.this,MainActivity.class);


                    SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = preferencias.edit();
                    String idUsuario = mascotas.getId();
                    edit.putString(JsonKeys.USER_ID, idUsuario);
                    edit.putString(JsonKeys.USER_FULLNAME,mascotas.getNombreCompleto());
                    edit.putString(JsonKeys.PROFILE_PICTURE,mascotas.getUrlfoto());
                    edit.commit();
                    startActivity(intent);

                    finish();

                }


            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {

            }
        });

          }


}




