package com.pokemon.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pokemon.entity.Pokemon;

import com.pokemon.repository.PokemonRepository;
import com.pokemon.service.IPokemonService;

@Service
public class PokemonServiceImpl implements IPokemonService{
	
	@Autowired
	PokemonRepository repository;
	
	@Override
	public ResponseEntity<String> savePokemon(Pokemon pokemon) {
		try {
			repository.save(pokemon);
			return new ResponseEntity<>("Pokemon creado", HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("Error en el aplicativo", HttpStatus.CONFLICT);
		}		
	}

	@Override
	public List<Pokemon> returnListPokemon() {
		List<Pokemon> lista = (List<Pokemon>) repository.findAll();
		return lista;
	}

	@Override
	public Pokemon returnPokemon(Integer id) {
		try {
			Optional<Pokemon> pokemon = repository.findById(id);
			return pokemon.get();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<String> deletePokemon(Integer id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>("Pokemon eliminado", HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("Error en el aplicativo", HttpStatus.CONFLICT);
		}
	}

	@Override
	public ResponseEntity<String> editPokemon(Pokemon pokemon) {
		try {
			repository.findById(pokemon.getId()).map(pokemonOb -> {
				pokemonOb.setNombre(pokemon.getNombre());
				pokemonOb.setTipo(pokemon.getTipo());
				pokemonOb.setHabilidades(pokemon.getHabilidades());
				pokemonOb.setTranformaciones(pokemon.getTranformaciones());
				repository.save(pokemonOb);
		        return new ResponseEntity<>("Pokemon editado", HttpStatus.OK); 
			});
		}catch(Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<>("Error en el aplicativo", HttpStatus.CONFLICT);
		}
		
		return null;
	}

	

}
