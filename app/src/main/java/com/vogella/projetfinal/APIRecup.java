package com.vogella.projetfinal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRecup {

    private final Gson gson;
    private final PokemonRestApi pokemonRestApi;

    private APIRecup(){
        gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        pokemonRestApi = retrofit.create(PokemonRestApi.class);


    }


    private static APIRecup INSTANCE = null;

    public static APIRecup getInstance()
    {
        if (INSTANCE == null)
        {   INSTANCE = new APIRecup();
        }
        return INSTANCE;
    }

    public PokemonRestApi getPokemonRestApi() {
        return pokemonRestApi;
    }
}
