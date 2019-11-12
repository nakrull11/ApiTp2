package com.example.consumicion.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.consumicion.model.ApiClient;
import com.example.consumicion.model.Municipio;
import com.example.consumicion.model.Resultado;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> lista;

    public LiveData<String> getLista()
    {
        if(lista==null){
            lista = new MutableLiveData<>();
        }
        return lista;
    }

    public void buscarVm(){
        Call<Resultado> datos = ApiClient.getInterfaceApi().leer();
        datos.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                if(response.isSuccessful()){
                    Resultado resultado = response.body();
                    StringBuffer cadena = new StringBuffer();

                    for (Municipio it:resultado.getMunicipios()) {
                        cadena.append(it.getNombre()+"\n");
                    }

                    lista.postValue(cadena.toString());
                }
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                lista.postValue(t.getMessage());
            }
        });
    }
}
