package com.vogella.projetfinal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.vogella.projetfinal.model.Pokemon;
import com.vogella.projetfinal.model.RestPokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final String PREFS = "PREFS";
    private static final String PREFS_NOMBRE = "PREFS_NOMBRE";
    private static final String PREFS_NAME = "PREFS_NAME";
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIRecup api = APIRecup.getInstance();


        Call<RestPokemonResponse> call = api.getPokemonRestApi().getListPokemon();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                RestPokemonResponse restPokemonResponse = response.body();
                List<Pokemon> listPokemon = restPokemonResponse.getResults();
                showList(listPokemon);
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                Log.d("Erreur", "API KO");
            }
        });

        sharedPreferences = getBaseContext().getSharedPreferences(PREFS, MODE_PRIVATE);

        if (sharedPreferences.contains(PREFS_NOMBRE) && sharedPreferences.contains(PREFS_NAME)) {

            int nb = sharedPreferences.getInt(PREFS_NOMBRE, 20);

            Toast.makeText(this, "il y a  " + nb + " pokemon", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Sauvegardé, relancez l'application pour voir le résultat", Toast.LENGTH_SHORT).show();
        }
    }


    private void showList(List<Pokemon> list) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapterPokemon(list);
        recyclerView.setAdapter(mAdapter);
    }

}