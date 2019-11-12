package com.example.consumicion.view;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.consumicion.model.ApiClient;
import com.example.consumicion.model.Provincia;
import com.example.consumicion.model.Provincias;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Provincias> listaNombre;

    private Provincias provincias;

    public LiveData<Provincias> getLista()
    {
        if(listaNombre==null){
            listaNombre = new MutableLiveData<>();
        }
        return listaNombre;
    }


    public void buscarVm(){
        Call<Provincias> datos = ApiClient.getInterfaceApi().leer();
        Log.d("datos",datos.toString());
        datos.enqueue(new Callback<Provincias>() {
            @Override
            public void onResponse(Call<Provincias> call, Response<Provincias> response) {
                if(response.isSuccessful()){

                    provincias = response.body();
                    StringBuffer cadena = new StringBuffer();

                    for (Provincia p : provincias.getProvincias()) {
                        cadena.append(p.getNombre());
                    }

                    listaNombre.postValue(provincias);
                }
            }

            @Override
            public void onFailure(Call<Provincias> call, Throwable t) {
                listaNombre.postValue(null);
            }
        });
    }
}
