package com.pokemon.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokemon.entity.PokemonCloud;
import com.pokemon.model.Response;
import com.pokemon.repository.PokemonCloudRepository;
import com.pokemon.service.IPokemonCloudService;

@Service
public class PokemonCloudServiceImpl implements IPokemonCloudService{
	@Autowired
	PokemonCloudRepository repositoryCloud;
	
	@Autowired
	private RestTemplate cliente;

	@Override
	public ResponseEntity<String> poblarTabla() {
		Response resp = cliente.getForObject("https://pokeapi.co/api/v2/pokemon?offset=01&limit=100", Response.class);
		try {
			if(!resp.getResults().isEmpty()) {
				resp.getResults().forEach(pokemon->{
					PokemonCloud pkC = new PokemonCloud();
					pkC.setName(pokemon.getName());
					pkC.setUrl(pokemon.getUrl());
					pkC.setCurrentDate(new Date());
					repositoryCloud.save(pkC);
				});
				return new ResponseEntity<>("Tabla Poblada", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("No hay conexion con el servicio", HttpStatus.OK);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("Error en el aplicativo", HttpStatus.CONFLICT);
		}
		
	}

	@Override
	public List<PokemonCloud> revisarTabla() {
		try {
			List<PokemonCloud> lista = (List<PokemonCloud>) repositoryCloud.findAll();
			return lista;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

}
