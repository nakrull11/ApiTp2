package com.example.consumicion.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.consumicion.R;

public class MainActivity extends AppCompatActivity  {
    private MainViewModel mainViewModel;
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
        tvNombreProv = findViewById(R.id.tvNombreProvincia);
        tvIdProv = findViewById(R.id.tvIdProvincia);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        /*mainViewModel.getLista().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        })*/;
    }
}
