package com.angel_fere.mascotas;

/**
 * Created by Angel_Fere on 19/07/2017.
 */

public class Mascotas {

    private String id;
    private String nombreCompleto;
    private  String urlfoto;
    private int likes = 0;


    public Mascotas(String id, String nombreCompleto, String urlfoto, int likes){
        this.urlfoto = urlfoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

public Mascotas(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


}
