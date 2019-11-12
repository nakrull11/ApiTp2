package com.example.consumicion.model;

import java.util.ArrayList;
import java.util.List;

public class Provincias {
    private int cantidad;
    private int inicio;
    private List<Provincia> provincias;
    private Parametro parametros;
    private int total;

    public Provincias(int cantidad, int inicio, List<Provincia> provincias, Parametro parametros, int total) {
        this.cantidad = cantidad;
        this.inicio = inicio;
        this.provincias = provincias;
        this.parametros = parametros;
        this.total = total;
    }

    public Provincias() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(ArrayList<Provincia> provincias) {
        this.provincias = provincias;
    }

    public Parametro getParametros() {
        return parametros;
    }

    public void setParametros(Parametro parametros) {
        this.parametros = parametros;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Provincias{" +
                "cantidad=" + cantidad +
                ", inicio=" + inicio +
                ", provincias=" + provincias +
                ", parametros=" + parametros +
                ", total=" + total +
                '}';
    }
}
