package com.example.consumicion.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.consumicion.model.ApiClient;
import com.example.consumicion.model.Provincia;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> listaNombre;

    private List<Provincia> provincias;

    public LiveData<String> getLista()
    {
        if(listaNombre==null){
            listaNombre = new MutableLiveData<>();
        }
        return listaNombre;
    }


    public void buscarVm(){
        Call<List<Provincia>> datos = ApiClient.getInterfaceApi().leer();
        datos.enqueue(new Callback<List<Provincia>>() {
            @Override
            public void onResponse(Call<List<Provincia>> call, Response<List<Provincia>> response) {
                if(response.isSuccessful()){

                    provincias = response.body();
                    StringBuffer cadena = new StringBuffer();

                    for(int i=0;i<provincias.size();i++) {
                        cadena.append(provincias.get(i).getNombre() + "\n");
                    }

                    listaNombre.postValue(cadena.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Provincia>> call, Throwable t) {
                listaNombre.postValue(t.getMessage());
            }
        });
    }
}
