package com.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.entity.PokemonCloud;
import com.pokemon.serviceImpl.PokemonCloudServiceImpl;


@RestController
@RequestMapping("/pokemones")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PokemonCloudController {
	
	@Autowired
	PokemonCloudServiceImpl service;
	
	@PostMapping("/poblar-tabla")
	@ResponseBody
	public ResponseEntity<String> poblarTabla(){
		return service.poblarTabla();
	}
	
	@GetMapping("/revisarTabla")
	@ResponseBody
	public List<PokemonCloud> revisarTabla(){
		return service.revisarTabla();
	}
	
}
