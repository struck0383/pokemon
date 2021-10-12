package com.pokemon.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pokemon.entity.Pokemon;

public interface IPokemonService {
	
	ResponseEntity<String> savePokemon(Pokemon pokemon);
	List<Pokemon> returnListPokemon();
	Pokemon returnPokemon(Integer id);
	ResponseEntity<String> deletePokemon(Integer id);
	ResponseEntity<String> editPokemon(Pokemon pokemon);	
	
}
