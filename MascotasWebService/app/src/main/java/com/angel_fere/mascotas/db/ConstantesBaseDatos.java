package com.angel_fere.mascotas.db;

/**
 * Created by Angel_Fere on 02/08/2017.
 */

public  final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 2;


    public static final String TABLE_MASCOTAS = "mascota";
    public static final String TABLE_MASCOTAS_ID = "id";
    public static final String TABLE_MASCOTAS_NOMBRE = "nombre";
    public static final String TABLE_MASCOTAS_FOTO = "foto";


    public static final String TABLE_LIKES_MASCOTAS = "mascotas_likes";
    public static final String TABLE_LIKES_MASCOTAS_ID = "id";
    public static final String TABLE_LIKES_MASCOTAS_ID_MASCOTAS = "id_contacto";
    public static final String TABLE_LIKES_MASCOTAS_ID_NUMERO_LIKES = "numero_likes" ;
}
