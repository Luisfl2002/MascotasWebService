package com.angel_fere.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.angel_fere.mascotas.Mascotas;
import com.angel_fere.mascotas.R;

import java.util.ArrayList;

/**
 * Created by Angel_Fere on 02/08/2017.
 */

public class ConstructorMascotas  {

    private Context context;
    private static  final int LIKE =0;

    public ConstructorMascotas(Context context){
        this.context = context;

    }


    public ArrayList<Mascotas> obtenerDatos(){


        BaseDatos db = new BaseDatos(context);


            if (db.obtenerTodasLasMascotas().size()==0) {

                insertarMascotas(db);
            }
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Alex");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.gatito);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Benji");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.salchicha);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Little");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.peque_ito);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Gorila");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.pug);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Lanudo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.lanudo);
        db.insertarMascotas(contentValues);



    }

    public void darLikeMascotas(Mascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS, mascotas.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_NUMERO_LIKES,LIKE);
        db.insertarLikeMascotas(contentValues);
    }


    public ArrayList<Mascotas> sacarFavoritos(){
        BaseDatos bd = new BaseDatos(this.context);
        return bd.mascotasFavoritas(5);

    }




}
