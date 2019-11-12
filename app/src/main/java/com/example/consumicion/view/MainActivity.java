package com.example.consumicion.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.consumicion.R;
import com.example.consumicion.model.Provincia;
import com.example.consumicion.model.Provincias;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private MainViewModel mainViewModel;
    private List<Provincias> lista;
    private TextView tvNombreProv;
    private TextView tvIdProv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    //Probando Pull


    public void mostrar(View view){
        mainViewModel.buscarVm();
    }

    public void inicializar(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getLista().observe(this, new Observer<List<Provincias>>() {
            @Override
            public void onChanged(List<Provincias> provincias) {
                lista = provincias;
                ArrayAdapter<Provincia> adapter = new ListaAdapter(getApplicationContext(),R.layout.item,lista,getLayoutInflater());
                ListView lv = findViewById(R.id.miLista);
                lv.setAdapter(adapter);
            }
        });
    }
}
