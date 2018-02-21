package com.example.alumnom.examen2rubenmartingomez;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alumnom on 21/02/2018.
 */

public class ArrayAdapterPais extends ArrayAdapter<Pais> {

    private Context context;
    private ArrayList<Pais> datos;

    public ArrayAdapterPais(Context context, int resource, ArrayList<Pais> datos) {
        super(context, resource, datos);

        this.context = context;
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Pais property = datos.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_item_pais, null);


        TextView tvNomI = (TextView) view.findViewById(R.id.tvNomI);
        TextView tvNomE = (TextView) view.findViewById(R.id.tvNomE);
        TextView tvCla = (TextView) view.findViewById(R.id.tvCla);
        TextView tvCap = (TextView) view.findViewById(R.id.tvCap);
        TextView tvCont = (TextView) view.findViewById(R.id.tvCont);

        TextView tvPobl = (TextView) view.findViewById(R.id.tvPobl);
        TextView tvLat = (TextView) view.findViewById(R.id.tvLat);
        TextView tvLon = (TextView) view.findViewById(R.id.tvLon);
        TextView tvFron = (TextView) view.findViewById(R.id.tvFron);

        tvNomI.setText(tvNomI.getText().toString()+property.getNombreIng());
        tvNomE.setText(tvNomE.getText().toString()+property.getNombreEsp());
        tvCla.setText(tvCla.getText().toString()+property.getClave());
        tvCap.setText(tvCap.getText().toString()+property.getCapital());
        tvCont.setText(tvCont.getText().toString()+property.getContinente());


        tvPobl.setText(tvPobl.getText().toString()+property.getPoblacion());
        tvLat.setText(tvLat.getText().toString()+Double.toString(property.getLatitud()) );
        tvLon.setText(tvLon.getText().toString()+Double.toString(property.getLongitud()));
        tvFron.setText(property.getClavePaisesFronterizos());
        return view;
    }
}