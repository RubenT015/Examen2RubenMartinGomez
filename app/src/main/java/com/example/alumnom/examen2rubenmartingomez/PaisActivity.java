package com.example.alumnom.examen2rubenmartingomez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PaisActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener  {

    GoogleMap mapa;
    SupportMapFragment fragmentMapa;
    double latitud;
    double longitud;

    LatLng pais;
    MarkerOptions marcador1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMapa= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        fragmentMapa.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa=googleMap;
        mapa.setMapType(googleMap.MAP_TYPE_NORMAL);
        mapa.getUiSettings().setZoomControlsEnabled(true);

        pais=new LatLng(40.4819791, -3.363542100000018);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(pais, 15));

        marcador1=new MarkerOptions().title("").position(pais).rotation(45.0f).icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador1));
        marcador1.draggable(true);
        mapa.addMarker(marcador1);

        latitud=pais.latitude;
        longitud=pais.longitude;

        mapa.setOnMarkerDragListener(this);
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        /*
        Toast.makeText(getApplicationContext(), "Cambiando coordenadas...", Toast.LENGTH_SHORT ).show();
        MarkerOptions marcadorOriginal=marcador1;
        marcadorOriginal.icon(BitmapDescriptorFactory.fromResource(R.drawable.origen));
        marcadorOriginal.title("Origen");
        mapa.addMarker(marcadorOriginal);
        */
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        /*
        latitud=marker.getPosition().latitude;
        longitud=marker.getPosition().longitude;

        tvLatitud.setText("Latitud: " + Double.toString(latitud));
        tvLongitud.setText("Longitud: " + Double.toString(longitud));
        */
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        /*
        Toast.makeText(getApplicationContext(), "Cambio de coordenadas finalizado", Toast.LENGTH_SHORT ).show();

        Location localizacionOriginal=new Location("Plaza Cervantes (Alcala de Henares)");
        localizacionOriginal.setLatitude(alcala.latitude);
        localizacionOriginal.setLongitude(alcala.longitude);

        Location localizacionFinal=new Location("Localización final");
        localizacionFinal.setLatitude(marker.getPosition().latitude);
        localizacionFinal.setLongitude(marker.getPosition().longitude);

        float distancia=localizacionOriginal.distanceTo(localizacionFinal);
        tvDistancia.setText("Distancia al origen: " + distancia+" m");
        */

    }
}
