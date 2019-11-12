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
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    //Probando Pull


    public void mostrar(View view){
        mainViewModel.buscarVm("74");
    }

    public void inicializar(){
        textView = findViewById(R.id.tvMunicipio);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getLista().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
    }
}
