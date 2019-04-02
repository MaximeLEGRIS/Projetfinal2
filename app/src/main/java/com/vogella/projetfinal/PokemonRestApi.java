package com.vogella.projetfinal;

import com.vogella.projetfinal.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface PokemonRestApi {
    //Call<RestPokemonResponse>
    @GET("pokemon")
    Call<RestPokemonResponse> getListPokemon();

    @GET("/abilities")
    Call<RestPokemonResponse> getListAbilities();
}