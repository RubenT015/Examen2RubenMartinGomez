package com.example.alumnom.examen2rubenmartingomez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {
    //http://restcountries.eu/rest/v2/all
    //http://192.168.31.44/Paises/paises.json

    private static final String URL = "http://restcountries.eu/rest/v2/all";
    private ListView lv;
    private ArrayList<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //paises.add(new Pais("", "", "", "", "", "", 0, 0, null));
        lv = (ListView) findViewById(R.id.lv);

        //Toast.makeText(getApplicationContext(),paises.get(0).getNombreIng(),Toast.LENGTH_SHORT).show();

        RequestQueue request = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayPrincipal = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {

            //JsonObjectRequest jsonObjectPrincipal = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONArray response) {
                paises = new ArrayList<Pais>();
                try {
                    JSONArray jsonList = response;
                    for (int i = 0; i < jsonList.length(); i++) {
                        //Toast.makeText(getApplicationContext(),i,Toast.LENGTH_SHORT).show();
                        String nombreIng = jsonList.getJSONObject(i).getString("name");
                        String nombreEsp = jsonList.getJSONObject(i).getJSONObject("translations").getString("es");
                        String clave = jsonList.getJSONObject(i).getString("alpha2Code");
                        String capital = jsonList.getJSONObject(i).getString("capital");
                        String continente = jsonList.getJSONObject(i).getString("region");
                        String poblacion = jsonList.getJSONObject(i).getString("population");
                        double latitud = 0;
                        double longitud = 0;
                        if(jsonList.getJSONObject(i).getJSONArray("latlng").length()>0){
                            latitud = Double.parseDouble(jsonList.getJSONObject(i).getJSONArray("latlng").getString(0));
                            longitud = Double.parseDouble(jsonList.getJSONObject(i).getJSONArray("latlng").getString(1));
                        }
                        ArrayList<String> paisesFronterizos = new ArrayList<>();
                        for (int i2 = 0; i2 < jsonList.getJSONObject(i).getJSONArray("borders").length();i2++){
                            paisesFronterizos.add(jsonList.getJSONObject(i).getJSONArray("borders").getString(i2));
                        }
                        paises.add(new Pais(nombreIng, nombreEsp, clave, capital, continente, poblacion, latitud, longitud, paisesFronterizos));
                    }
                    listView(paises);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.add(jsonArrayPrincipal);

        //Toast.makeText(getApplicationContext(),Integer.toString(paises.size()),Toast.LENGTH_SHORT).show();
        //ArrayAdapterPais arrayAdapter = new ArrayAdapterPais(this,0, paises);
        //lv.setAdapter(arrayAdapter);
    }

    public void listView(ArrayList<Pais> p){

        ArrayAdapterPais arrayAdapter = new ArrayAdapterPais(this,0, p);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent i = new Intent(MainActivity.this, PaisActivity.class);
                i.putExtra("latitud",paises.get(position).getLatitud());
                i.putExtra("longitud",paises.get(position).getLongitud());
                //i.putExtra("style",R.style.Theme4);
                startActivity(i);
            }
        });
    }
}
