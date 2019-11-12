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

    private MutableLiveData<List<Provincias>> listaNombre;

    private List<Provincias> provincias;

    public LiveData<List<Provincias>> getLista()
    {
        if(listaNombre==null){
            listaNombre = new MutableLiveData<>();
        }
        return listaNombre;
    }


    public void buscarVm(){
        Call<List<Provincias>> datos = ApiClient.getInterfaceApi().leer();
        Log.d("datos",datos.toString());
        datos.enqueue(new Callback<List<Provincias>>() {
            @Override
            public void onResponse(Call<List<Provincias>> call, Response<List<Provincias>> response) {
                if(response.isSuccessful()){

                    provincias = response.body();
                    StringBuffer cadena = new StringBuffer();

                    for(int i=0;i<provincias.size();i++) {
                        cadena.append(provincias.get(i).getProvincias() + "\n");
                    }

                    listaNombre.postValue(provincias);
                }
            }

            @Override
            public void onFailure(Call<List<Provincias>> call, Throwable t) {
                listaNombre.postValue(null);
            }
        });
    }
}
