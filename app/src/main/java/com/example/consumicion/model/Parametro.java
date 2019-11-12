package com.example.consumicion.model;

import java.util.ArrayList;

public class Parametro {

    private ArrayList<String> provincia;

    public Parametro(ArrayList<String> provincia) {
        this.provincia = provincia;
    }

    public Parametro() {
    }

    @Override
    public String toString() {
        return "Parametro{" +
                "provincia=" + provincia +
                '}';
    }
}
