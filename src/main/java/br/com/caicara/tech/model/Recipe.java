package br.com.caicara.tech.model;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {
	
	private static final long serialVersionUID = 1360150998215014060L;
	private long id;
	private String name;
	private List<Ingredient> ingredients;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	

}
