package com.example.consumicion.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.consumicion.R;
import com.example.consumicion.model.Provincia;
import com.example.consumicion.model.Provincias;

import java.util.List;

public class ListaAdapter extends ArrayAdapter<Provincia> {
    private Context context;
    private List<Provincias> lista;
    private LayoutInflater li;
    public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Provincias> objects, LayoutInflater li) {
        super(context, resource);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;
        if(itemView == null)
        {
            itemView = li.inflate(R.layout.item,parent,false);

        }
        Provincias provincia = lista.get(position);

        TextView nombreProvincia = itemView.findViewById(R.id.tvNombreProvincia);

        nombreProvincia.setText(provincia.getProvincias().get(position).getNombre());

        TextView idProvincia = itemView.findViewById(R.id.tvIdProvincia);

        idProvincia.setText(provincia.getProvincias().get(position).getId());

        return itemView;
    }
}
