package com.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.entity.Pokemon;
import com.pokemon.serviceImpl.PokemonServiceImpl;



@RestController
@RequestMapping("/pokemones")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PokemonController {
	@Autowired
	PokemonServiceImpl service;
		
	@PostMapping("/savePokemon")
	@ResponseBody
	public ResponseEntity<String> savePokemon(@RequestBody Pokemon pokemon) {
		return service.savePokemon(pokemon);		
	}
	
	@GetMapping("/returnPokemonList")
	@ResponseBody
	public List<Pokemon> returnListPokemon(){
		return service.returnListPokemon();
	}
	
	@GetMapping("/returnPokemon/{id}")
	@ResponseBody
	public Pokemon returnPokemon(@PathVariable Integer id){
		return service.returnPokemon(id);
	}
	
	@DeleteMapping("/deletePokemon/{id}")
	@ResponseBody
	public ResponseEntity<String> deletePokemon(@PathVariable Integer id){
		return service.deletePokemon(id);
	}
	
	@PostMapping("/editPokemon/")
	@ResponseBody
	public ResponseEntity<String> editPokemon(@RequestBody Pokemon pokemon){
		return service.editPokemon(pokemon);
	}	
	
}
