package com.angel_fere.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.angel_fere.mascotas.Mascotas;

import java.util.ArrayList;

/**
 * Created by Angel_Fere on 02/08/2017.
 */

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



      String  queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST"+ ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST"+ ConstantesBaseDatos.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerTodasLasMascotas(){

        ArrayList<Mascotas> mascotas = new ArrayList<>();
        String query   = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
      /* Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_NUMERO_LIKES+ " ) as likes" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS +
                    " = " + mascotaActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes,null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));

            }else{
                mascotas.add(mascotaActual);
            }

                    mascotas.add(mascotaActual);*/
        }
        db.close();
        return mascotas;
    }


    public void insertarMascotas(ContentValues contentValues){
    SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        db.close();

    }


    public void insertarLikeMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS,null, contentValues);
        db.close();

    }

    public int obtenerLikesMascotas(Mascotas mascotas){

        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + " = " + mascotas.getId();


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while  (registros.moveToNext()){
            likes = registros.getInt(0);



        }
        db.close();

        return likes;
    }

    public ArrayList<Mascotas> mascotasFavoritas(int numero) {
        ArrayList<Mascotas> mascotas = new ArrayList<>();


        String query = "SELECT *,(" +  "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_NUMERO_LIKES + ") " +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + "." + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTAS + " = " +
                ConstantesBaseDatos.TABLE_MASCOTAS + "." + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ") as likes " +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " ORDER BY likes DESC" +
                " LIMIT " + String.valueOf(numero);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while ( registros.moveToNext() ) {
            Mascotas mascotaActual = new Mascotas();
           // mascotaActual.setId( registros.getInt(0) );
           // mascotaActual.setNombre( registros.getString(1) );
           // mascotaActual.setFoto( registros.getInt(2) );
            mascotaActual.setLikes( registros.getInt(3));
            if (mascotaActual.getLikes() > 0) {
                mascotas.add(mascotaActual);
            }
        }

        return mascotas;
    }

}
