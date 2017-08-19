package com.angel_fere.mascotas.restApi;

import com.angel_fere.mascotas.MascotaResponse;
import com.angel_fere.mascotas.Mascotas;
import com.angel_fere.mascotas.db.ConstantesBaseDatos;

import java.net.ContentHandler;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Angel_Fere on 14/08/2017.
 */

public interface EndpointsApi {
    /*
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();
*/

    @GET("users/{userid}/media/recent/"+ConstantesRestApi.KEY_ACCESS_TOKEN +ConstantesRestApi.ACCESS_TOKEN)
    Call<MascotaResponse> getRecentMedia(@Path("userid") String userid, @Query("access_token")String accesstoken);


    @GET("users/search")
    public Call<MascotaResponse> search(@Query("q") String query, @Query("access_token") String access_token);


    Call<MascotaResponse> Search();
}
