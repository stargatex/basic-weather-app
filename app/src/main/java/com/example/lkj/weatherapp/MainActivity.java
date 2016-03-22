package com.example.lkj.weatherapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lkj.weatherapp.model.WeatherFactory;
import com.example.lkj.weatherapp.view.WeaterIcon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView city, wStatus, wDes, wTemp, wIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        city = (TextView) findViewById(R.id.cityName);
        wStatus = (TextView) findViewById(R.id.wMain);
        wDes = (TextView) findViewById(R.id.wDes);
        wTemp = (TextView) findViewById(R.id.wTemp);
        wIcon = (TextView) findViewById(R.id.weatherIcon);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Snackbar.make(view, "Currently, No Location Based Service ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }


        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), "Retrieving " + query, Toast.LENGTH_LONG).show();

                WeatherFactory.getService().getWeather(String.valueOf(query), "metric").enqueue(new Callback<com.example.lkj.weatherapp.model.weathermodel.Weather>() {
                    @Override
                    public void onResponse(Call<com.example.lkj.weatherapp.model.weathermodel.Weather> call, Response<com.example.lkj.weatherapp.model.weathermodel.Weather> response) {

                        city.setText(response.body().getName());
                        wStatus.setText(response.body().getWeather().get(0).getMain());
                        wDes.setText(response.body().getWeather().get(0).getDescription());
                        wTemp.setText(String.valueOf(response.body().getMain().getTemp()).concat(" C"));
                        wIcon.setText(WeaterIcon.getIconString(response.body().getWeather().get(0).getId(), response.body().getWeather().get(0).getIcon()));
                        Log.i("LJ_SNK", "Success");

                    }

                    @Override
                    public void onFailure(Call<com.example.lkj.weatherapp.model.weathermodel.Weather> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                        Log.i("LJ_SNK_F", t.getMessage());
                    }
                });

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
