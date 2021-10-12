package com.pokemon.model;

import java.util.List;

import lombok.Data;

@Data
public class Response {
	
	private Integer count;
	private String next;
	private String previous;
	private List<Results> results;
	
	public Response(){
		
	}
	
	public Response(Integer count, String next, String previous, List<Results> results) {		
		this.count = count;
		this.next = next;
		this.previous = previous;
		this.results = results;
	}
	
	
	
}
