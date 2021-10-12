package com.pokemon.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pokemon.entity.PokemonCloud;

public interface IPokemonCloudService {
	ResponseEntity<String> poblarTabla();
	List<PokemonCloud> revisarTabla();
}
