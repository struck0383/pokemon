package com.pokemon.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Pokemon implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	@Column(name="pokemon_nombre")
	protected String nombre;
	@Column(name="pokemon_tipo")
	protected String tipo;
	@Column(name="habilidades")
	@ElementCollection(targetClass=String.class)
	protected List<String> habilidades;
	@Column(name="transformaciones")
	@ElementCollection(targetClass=String.class)
	protected List<String> tranformaciones;
	
	public Pokemon() {}

	public Pokemon(int id, String nombre, List<String> habilidades, List<String> tranformaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.habilidades = habilidades;
		this.tranformaciones = tranformaciones;
	}
	
	
	
	
	
	
	

}
