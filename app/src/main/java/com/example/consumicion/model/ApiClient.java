package com.example.consumicion.model;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiClient {

    private static final String PATH="https://apis.datos.gob.ar/georef/api/";
    private static  ApiInterface interfaceApi;


    public static ApiInterface getInterfaceApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        interfaceApi = retrofit.create(ApiInterface.class);
        Log.d("pasando por call","call");
        return  interfaceApi;
    }




    public interface ApiInterface{
        @GET("provincias")
        Call<Provincias> leer();

    }
}
