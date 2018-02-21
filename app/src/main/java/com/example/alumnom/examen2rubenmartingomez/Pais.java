package com.example.alumnom.examen2rubenmartingomez;

import java.util.ArrayList;

/**
 * Created by alumnom on 21/02/2018.
 */

public class Pais {
    private String nombreIng;
    private String nombreEsp;
    private String clave;
    private String capital;
    private String continente;

    private String poblacion;
    private double latitud;
    private double longitud;
    private ArrayList<String> paisesFronterizos;

    public Pais(String nombreIng, String nombreEsp, String clave, String capital, String continente, String poblacion, double latitud, double longitud, ArrayList<String> paisesFronterizos) {
        this.nombreIng = nombreIng;
        this.nombreEsp = nombreEsp;
        this.clave = clave;
        this.capital = capital;
        this.continente = continente;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.paisesFronterizos = paisesFronterizos;
    }

    public String getNombreIng() {
        return nombreIng;
    }

    public void setNombreIng(String nombreIng) {
        this.nombreIng = nombreIng;
    }

    public String getNombreEsp() {
        return nombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public ArrayList<String> getPaisesFronterizos() {
        return paisesFronterizos;
    }

    public void setPaisesFronterizos(ArrayList<String> paisesFronterizos) {
        this.paisesFronterizos = paisesFronterizos;
    }

    public String getClavePaisesFronterizos() {
        String claves ="";
        boolean primero = true;
        for (String c:paisesFronterizos) {
            if(!primero){
                claves +=" ";
            }else{
                primero=false;
            }
            claves +=c;
        }
        return claves;
    }
}
