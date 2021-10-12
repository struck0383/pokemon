package com.pokemon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon,Integer>{

}
